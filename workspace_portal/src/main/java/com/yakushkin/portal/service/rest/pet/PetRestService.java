package com.yakushkin.portal.service.rest.pet;

import com.yakushkin.portal.http.rest.endpoints.pet.PetEndpoint;
import com.yakushkin.portal.http.rest.request.pet.PetRequestBody;
import com.yakushkin.portal.http.rest.response.pet.PetResponseBody;
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
    private final PetEndpoint petEndpoint;

    public PetResponseBody findAll() {
        return restTemplate.getForObject(
                petEndpoint.endpointGetAll,
                PetResponseBody.class
        );
    }

    public PetResponseBody findById(Long petId) {
        return restTemplate.getForObject(
                petEndpoint.endpointGetById,
                PetResponseBody.class,
                petId
        );
    }

    public PetResponseBody save(PetRequestBody requestBody) {
        return restTemplate.postForObject(
                petEndpoint.endpointRegistration,
                requestBody,
                PetResponseBody.class
        );
    }

    public PetResponseBody update(PetRequestBody requestBody, Long petId) {
        RequestEntity<PetRequestBody> request = RequestEntity
                .put(petEndpoint.endpointUpdate, petId)
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestBody);
        return restTemplate
                .exchange(request, PetResponseBody.class)
                .getBody();
    }

    public ResponseEntity<?> delete(Long petId) {
        RequestEntity<Void> request = RequestEntity
                .delete(petEndpoint.endpointDelete, petId)
                .build();
        return restTemplate
                .exchange(request, ResponseEntity.class)
                .getBody();
    }
}
