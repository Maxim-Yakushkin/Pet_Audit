package com.yakushkin.portal.http.rest.controller.pet;

import com.yakushkin.portal.http.rest.request.pet.PetRequestBody;
import com.yakushkin.portal.http.rest.response.pet.PetResponseBody;
import com.yakushkin.portal.service.rest.pet.PetRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/portal", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PetRestController {

    private final PetRestService petRestService;

    @GetMapping(value = "/pets")
    public PetResponseBody findAll() {
        return petRestService.findAll();
    }

    @GetMapping(value = "/pets/{id}")
    public PetResponseBody findById(@PathVariable("id") Long petId) {
        return petRestService.findById(petId);
    }

    @PostMapping(
            value = "/pets",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PetResponseBody save(@RequestBody PetRequestBody requestBody) {
        return petRestService.save(requestBody);
    }

    @PutMapping(
            value = "/pets/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PetResponseBody update(@RequestBody PetRequestBody requestBody,
                                  @PathVariable("id") Long petId) {
        return petRestService.update(requestBody, petId);
    }

    @DeleteMapping(value = "/pets/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long petId) {
        return petRestService.delete(petId);
    }
}
