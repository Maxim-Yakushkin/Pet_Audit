package com.yakushkin.portal.http.rest.endpoints.pet;

import org.springframework.beans.factory.annotation.Value;

public final class PetEndpoint {

    @Value("${pet.api.get.allPets:}")
    public String endpointGetAll;
    @Value("${pet.api.get.byId:}")
    public String endpointGetById;
    @Value("${pet.api.post.registration:}")
    public String endpointRegistration;
    @Value("${pet.api.put.updateById:}")
    public String endpointUpdate;
    @Value("${pet.api.delete.deleteById:}")
    public String endpointDelete;
}
