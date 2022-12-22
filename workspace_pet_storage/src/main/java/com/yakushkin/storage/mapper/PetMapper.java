package com.yakushkin.storage.mapper;

import com.yakushkin.storage.entity.PetEntity;
import com.yakushkin.storage.request.pet.PetRequestBody;

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

    public static PetEntity mergeRequestBodyToEntity(PetRequestBody from, PetEntity to) {
        to.setName(from.getName());
        to.setBirthday(from.getBirthday());
        to.setPetType(from.getPetType());
        to.setChipped(from.getChipped());
        to.setTypeOfAccommodation(from.getTypeOfAccommodation());

        return to;
    }
}
