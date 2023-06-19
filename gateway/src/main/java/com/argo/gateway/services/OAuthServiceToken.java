package com.argo.gateway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class OAuthServiceToken {

    private final String clientId = "583458414138-ve02jfni5hat2f1aqs3lpol8kv8j229t.apps.googleusercontent.com";
    private final String clientSecret = "60AXVP1AR8SF5WmYYPVgSCTf";
    private final String redirectUrl = "http://localhost:7891/oauth/token";
    private final String URLTOKEN = "https://oauth2.googleapis.com/token";


    private final RestTemplate restTemplate;

    @Autowired
    public OAuthServiceToken(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Map getToken(HttpServletRequest request1) {

        String url = request1.getQueryString();


        boolean cs = url.startsWith("code=");

        if (cs) {
            String code = url.split("&")[0];


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();


            map.add("code", code.split("code=")[1]);
            map.add("client_id", clientId);
            map.add("client_secret", clientSecret);
            map.add("redirect_uri", redirectUrl);
            map.add("grant_type", "authorization_code");


            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

            ResponseEntity<?> rs = restTemplate.exchange(URLTOKEN, HttpMethod.POST, entity, Map.class);

            return (Map<String, ?>) rs.getBody();
        } else {
            return new HashMap();
        }
    }
}
