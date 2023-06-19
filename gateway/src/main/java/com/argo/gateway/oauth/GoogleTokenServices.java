package com.argo.gateway.oauth;

import com.argo.gateway.oauth.dto.responseAuthGoogle;
import com.argo.gateway.rol.domain.repositroy.IRol;
import com.argo.gateway.user.domain.repository.IAccess;
import com.commons.user.models.entity.accessUser.domain.Access;
import com.commons.user.models.entity.user.domain.User;

import com.argo.gateway.user.domain.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singleton;

@Service("googleService")
public class GoogleTokenServices implements ResourceServerTokenServices {


    private final AccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();

    @Autowired
    @Qualifier("userRepo")
    private IUser iUser;
    @Autowired
    private IRol iRol;
    private String userInfoUrl;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    @Qualifier("google")
    private GoogleAccessTokenValidator googleAccessTokenValidator;

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {

        System.out.println("entre aca en la autenticacion");
         responseAuthGoogle validate = this.googleAccessTokenValidator.validate(accessToken);
        if (!validate.isValidate()) {
            throw new UnapprovedClientAuthenticationException("Este token no sirve ga.");
        }
        Map<String, ?> tokenInfo = validate.getResponse();
        System.out.println(tokenInfo);
            OAuth2Authentication authentication = getAuthentication(tokenInfo, accessToken);
        
        return authentication;
    }

    private OAuth2Authentication getAuthentication(Map<String, ?> tokenInfo, String accessToken) {


        System.out.println("Esta es la informacion del token"+tokenInfo);
        OAuth2Request request = tokenConverter.extractAuthentication(tokenInfo).getOAuth2Request();
        Authentication authentication = getAuthenticationToken(accessToken);
        return new OAuth2Authentication(request, authentication);
    }

    private Authentication getAuthenticationToken(String accessToken) {

        String idStr = getIdUser(accessToken);



        String email = getEmail(accessToken);


        User userSaved = this.iUser.findById(idStr).orElseGet(() -> {


            User user = new User();
            user.setEmail(email);
            user.setIdUser(idStr);
            user.setIdRol(this.iRol.getOne(1));
            return this.iUser.save(user);
        });



        return new UsernamePasswordAuthenticationToken(new GooglePrincipal(new BigInteger(idStr)), null, singleton(new SimpleGrantedAuthority("ROLE_" + userSaved.getIdRol().getRol())));
    }


    public String getEmail(String accessToken) {



        return getUserInfo(accessToken).getEmail();

    }

    private String getIdUser(String accessToken) {

        String idStr = getUserInfo(accessToken).getSub();
        if (idStr == null) {
            throw new InternalAuthenticationServiceException("Cannot get id from user info");
        }
        return idStr;
    }

    private Access getUserInfo(String accessToken) {

        System.out.println(accessToken);
        Access access = this.iAccess.findByToken(accessToken).<UnapprovedClientAuthenticationException>orElseThrow(() -> {
             throw new UnapprovedClientAuthenticationException("Este token no sirve ga.");
        });


        return  access;
    }







    private HttpHeaders getHttpHeaders(String accessToken) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        return headers;
    }

    @Override
    public OAuth2AccessToken readAccessToken(String accessToken) {
        throw new UnsupportedOperationException("Not supported: read access token");
    }

    public void setUserInfoUrl(String userInfoUrl) {
        this.userInfoUrl = userInfoUrl;
    }

    @Autowired
    private IAccess  iAccess;
}
