package com.yakushkin.storage.controller.pet;

import com.yakushkin.storage.entity.PetEntity;
import com.yakushkin.storage.mapper.PetMapper;
import com.yakushkin.storage.request.pet.PetRequestBody;
import com.yakushkin.storage.response.pet.PetResponseBody;
import com.yakushkin.storage.service.pet.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
public class PetController {

    private static final String CURLY_BRACE_LEFT = "{";
    private static final String CURLY_BRACE_RIGHT = "}";
    private static final String CUR_ID = "cur_id";
    private static final String PATH_VARIABLE_CURRENCY_ID = CURLY_BRACE_LEFT + CUR_ID + CURLY_BRACE_RIGHT;
    private static final String GET_TEMPLATE_RATE_BY_CURRENCY_ID = "https://www.nbrb.by/api/exrates/rates/" + PATH_VARIABLE_CURRENCY_ID;
    private final RestTemplate restTemplate;
    private final PetService petService;

    @GetMapping("rates/" + PATH_VARIABLE_CURRENCY_ID)
    public String getCurById(@PathVariable(CUR_ID) Integer curId) {
        return restTemplate.getForObject(
                GET_TEMPLATE_RATE_BY_CURRENCY_ID,
                String.class,
                curId
        );
    }

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
