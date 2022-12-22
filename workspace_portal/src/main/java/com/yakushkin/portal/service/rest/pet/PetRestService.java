package com.yakushkin.portal.service.rest.pet;

import com.yakushkin.portal.request.pet.PetRequestBody;
import com.yakushkin.portal.response.pet.PetResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PetRestService {

    private final RestTemplate restTemplate;

    public PetResponseBody findAll() {
        return restTemplate.getForObject(
                "http://localhost:8082/api/v1/pets",
                PetResponseBody.class
        );
    }

    public PetResponseBody findById(Long petId) {
        return restTemplate.getForObject(
                "http://localhost:8082/api/v1/pets/{id}",
                PetResponseBody.class,
                petId
        );
    }

    public PetResponseBody save(PetRequestBody requestBody) {
        return restTemplate.postForObject(
                "http://localhost:8082/api/v1/pets/registration",
                requestBody,
                PetResponseBody.class
        );
    }

    public PetResponseBody update(PetRequestBody requestBody, Long petId) {
        RequestEntity<PetRequestBody> request = RequestEntity
                .put("http://localhost:8082/api/v1/pets/{id}", petId)
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestBody);
        return restTemplate
                .exchange(request, PetResponseBody.class)
                .getBody();
    }

    public ResponseEntity<?> delete(Long petId) {
        RequestEntity<Void> request = RequestEntity
                .delete("http://localhost:8082/api/v1/pets/{id}", petId)
                .build();
        return restTemplate
                .exchange(request, ResponseEntity.class)
                .getBody();
    }
}
