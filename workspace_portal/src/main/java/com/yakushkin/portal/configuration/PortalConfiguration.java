package com.yakushkin.portal.configuration;

import com.yakushkin.portal.http.rest.endpoints.pet.PetEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource(value = {"classpath:pet_storage_endpoint.properties"})
public class PortalConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public PetEndpoint petEndpoint() {
        return new PetEndpoint();
    }
}
