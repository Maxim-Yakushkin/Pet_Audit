package com.yakushkin.storage.http.rest.pet;

import com.yakushkin.storage.entity.PetEntity;
import com.yakushkin.storage.mapper.PetMapper;
import com.yakushkin.storage.http.rest.request.pet.PetRequestBody;
import com.yakushkin.storage.http.rest.response.pet.PetResponseBody;
import com.yakushkin.storage.service.pet.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/pets", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PetStorageRestController {

    private final PetService petService;

    @GetMapping
    public PetResponseBody findAll() {
        return PetResponseBody.builder()
                .data(Optional.of(petService.findAll()))
                .message("All Pets request")
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("/{id}")
    public PetResponseBody findById(@PathVariable Long id) {
        return PetResponseBody.builder()
                .data(Optional.ofNullable(petService.findById(id)))
                .message("Find Pet by ID request")
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping(
            value = "/registration",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PetResponseBody save(@RequestBody PetRequestBody petRequestBody) {

        PetEntity pet = PetMapper.requestBodyToEntity(petRequestBody);
        PetEntity savedPet = petService.save(pet);

        return PetResponseBody.builder()
                .data(Optional.ofNullable(savedPet))
                .message("Save Pet request")
                .status(HttpStatus.OK)
                .build();
    }

    @PutMapping("/{id}")
    public PetResponseBody update(@PathVariable("id") Long petId,
                                  @RequestBody PetRequestBody petRequestBody) {

        return petService.update(petId, petRequestBody)
                .map(pet -> PetResponseBody.builder()
                        .data(Optional.of(pet))
                        .message("Update Pet request")
                        .status(HttpStatus.OK)
                        .build())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long petId) {
        return petService.delete(petId)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
