package com.yakushkin.portal.service.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// TODO: 22.12.2022 Create All CRUD operations
@Service
@RequiredArgsConstructor
public class PetService {

    private final RestTemplate restTemplate;

    public String findAll() {
        return restTemplate.getForObject(
                "http://localhost:8082/api/v1/pets",
                String.class
        );
    }
}
