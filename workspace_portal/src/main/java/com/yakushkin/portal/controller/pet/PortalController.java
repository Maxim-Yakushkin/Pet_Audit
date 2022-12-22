package com.yakushkin.portal.controller.pet;

import com.yakushkin.portal.service.pet.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: 22.12.2022 CRUD operations
@RestController
@RequestMapping("/api/v1/portal")
@RequiredArgsConstructor
public class PortalController {

    private final PetService petService;

    @GetMapping(
            value = "/pets",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String findAll() {
        return petService.findAll();
    }
}
