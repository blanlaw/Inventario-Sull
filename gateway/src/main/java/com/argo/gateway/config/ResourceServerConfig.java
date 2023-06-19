package com.argo.gateway.config;



import com.argo.gateway.oauth.GoogleTokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

    @Value("${oauth.clientId}")
    private String clientId;

    @Value("${oauth.clientmovil}")
    private String clientMovil;


    @Value("${oauth.userInfoUrl}")
    private String userInfoUrl;


    @Autowired
    @Qualifier("googleService")
    private GoogleTokenServices googleTokenServices;


    @Bean
    protected ResourceServerConfiguration WebResource() {
        ResourceServerConfiguration resource = new ResourceServerConfiguration() {
            public void setConfigurers(List<ResourceServerConfigurer> configurers) {

                super.setConfigurers(configurers);
            }
        };
        resource.setConfigurers(Collections.singletonList(new ResourceServerConfigurerAdapter() {
            @Override
            public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

                resources.resourceId(getClientId());
            }

            @Override
            public void configure(HttpSecurity http) throws Exception {

                http.antMatcher("/inventario/**").authorizeRequests().anyRequest().authenticated();

            }


        }));
        resource.setOrder(3);
        return resource;
    }

    @Bean
    protected ResourceServerConfiguration MovilResouce() {
        ResourceServerConfiguration resource = new ResourceServerConfiguration() {
            public void setConfigurers(List<ResourceServerConfigurer> configurers) {
                super.setConfigurers(configurers);
            }
        };
        resource.setConfigurers(Collections.singletonList(new ResourceServerConfigurerAdapter() {
            @Override
            public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
                resources.resourceId(getClientMovil());
            }

            @Override
            public void configure(HttpSecurity http) throws Exception {

                http.antMatcher("/api/inventario/**").authorizeRequests().anyRequest().authenticated();
            }
        }));
        resource.setOrder(4);

        return resource;
    }


    @Bean
    public CorsConfigurationSource corsconfiguration() {
        CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowedOrigins(Arrays.asList("*"));
            cors.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
        cors.setAllowCredentials(true);
        cors.setAllowedHeaders(Arrays.asList("Authorization", "Content-type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cors);
        return source;


    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new org.springframework.web.filter.CorsFilter(corsconfiguration()));

        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;


    }





    @Bean
    public ResourceServerTokenServices tokenServices() {

        googleTokenServices.setUserInfoUrl(this.getUserInfoUrl());
        return googleTokenServices;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUserInfoUrl() {
        return userInfoUrl;
    }

    public void setUserInfoUrl(String userInfoUrl) {
        this.userInfoUrl = userInfoUrl;
    }

    public String getClientMovil() {
        return clientMovil;
    }

    public void setClientMovil(String clientMovil) {
        this.clientMovil = clientMovil;
    }
}
