package com.argo.gateway.oauth;

import com.argo.gateway.oauth.dto.responseAuthGoogle;
import com.argo.gateway.user.domain.repository.IAccess;
import com.commons.user.models.entity.accessUser.domain.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service("google")
public class GoogleAccessTokenValidator {


    @Autowired
    private IAccess iAccess;

    @Value("${oauth.clientId}")
    private String clientId;

    @Value("${oauth.clientmovil}")
    private String clientIdMovil;


    @Value("${oauth.checkTokenUrl}")
    private String checkTokenUrl;

    @Autowired
    private RestTemplate restTemplate;

    @PostConstruct
    public void defineHandler() {
        this.restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response.getRawStatusCode() == 400) {
                    throw new InvalidTokenException("El token es invalido");
                }
            }
        });
    }


    public responseAuthGoogle validate(String accessToken) {
        System.out.println("estoy validando :" + accessToken);



        Map<String, ?> response = getGoogleResponse(accessToken);


        boolean b = validateResponse(response);


        return new responseAuthGoogle(response, b);

    }

    private boolean validateResponse(Map<String, ?> response) throws AuthenticationException {

        String aud = (String) response.get("aud");

        if (aud.equalsIgnoreCase(this.getClientId())) {

            return true;
        } else return aud.equalsIgnoreCase(this.getClientIdMovil());


    }

    @Transactional(rollbackFor = Exception.class)
    public Map<String, ?> getGoogleResponse(String accessToken) {

        try {

            Optional<Access> byToken = this.iAccess.findByToken(accessToken);
            if (!byToken.isPresent()) {
                Map<String, Object> map = (Map<String, Object>) restTemplate.exchange(checkTokenUrl + accessToken, HttpMethod.GET, null, Map.class).getBody();


                Access dd = new Access();
                dd.setToken(accessToken);
                dd.setAud(map.get("aud").toString());
                dd.setScope(map.get("scope").toString());
                dd.setExp(map.get("exp").toString());
                dd.setEmail(map.get("email").toString());
                dd.setAccess_type(map.get("access_type").toString());
                dd.setSub(map.get("sub").toString());
                dd.setSessionId("null");
                Date date = new Date();

                Access save = this.iAccess.save(dd);

                return map;
            }
            Access access = byToken.get();
            Map<String, Object> mapa = new HashMap<>();
            mapa.put("aud", access.getAud());
            mapa.put("scope", access.getScope());
            mapa.put("exp", access.getExp());
            mapa.put("email", access.getEmail());
            mapa.put("access_type", access.getAccess_type());
            mapa.put("sub",access.getSub());

            return mapa;

        }catch (Exception ex){
            throw new RuntimeException("Error al guardar el token");
        }
    }


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getCheckTokenUrl() {
        return checkTokenUrl;
    }

    public void setCheckTokenUrl(String checkTokenUrl) {
        this.checkTokenUrl = checkTokenUrl;
    }


    public String getClientIdMovil() {
        return clientIdMovil;
    }

    public void setClientIdMovil(String clientIdMovil) {
        this.clientIdMovil = clientIdMovil;
    }
}
