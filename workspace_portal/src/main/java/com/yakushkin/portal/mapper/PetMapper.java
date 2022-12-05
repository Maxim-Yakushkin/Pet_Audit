package com.yakushkin.portal.mapper;

import com.yakushkin.portal.entity.PetEntity;
import com.yakushkin.portal.request.pet.PetRequestBody;

public class PetMapper {

    public static PetEntity requestBodyToEntity(PetRequestBody petRequestBody) {
        return PetEntity.builder()
                .name(petRequestBody.getName())
                .petType(petRequestBody.getPetType())
                .birthday(petRequestBody.getBirthday())
                .chipped(petRequestBody.getChipped())
                .typeOfAccommodation(petRequestBody.getTypeOfAccommodation())
                .build();
    }
}
