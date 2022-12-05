package com.yakushkin.portal.controller.pet;

import com.yakushkin.portal.entity.PetEntity;
import com.yakushkin.portal.mapper.PetMapper;
import com.yakushkin.portal.request.pet.PetRequestBody;
import com.yakushkin.portal.response.pet.PetResponseBody;
import com.yakushkin.portal.service.pet.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @GetMapping
    public List<PetEntity> findAll() {
        return petService.findAll();
    }

    @GetMapping("/{id}")
    public PetResponseBody findById(@PathVariable Long id) {
        return PetResponseBody.builder()
                .data(petService.findById(id))
                .message("Success")
                .build();
    }

    @PostMapping(
            value = "/registration",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public PetResponseBody save(@RequestBody PetRequestBody petRequestBody) {

        if (petRequestBody == null) {
            return PetResponseBody.builder()
                    .data(null)
                    .message("Please provide request body as JSON")
                    .build();
        }

        PetEntity pet = PetMapper.requestBodyToEntity(petRequestBody);

        PetEntity savedPet = petService.save(pet);

        return PetResponseBody.builder()
                .data(savedPet)
                .message("Success")
                .build();
    }
}
