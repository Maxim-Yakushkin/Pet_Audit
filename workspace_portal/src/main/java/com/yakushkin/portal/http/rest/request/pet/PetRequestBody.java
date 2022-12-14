package com.yakushkin.portal.http.rest.request.pet;

import com.yakushkin.portal.http.rest.request.pet.enumiration.AccommodationType;
import com.yakushkin.portal.http.rest.request.pet.enumiration.PetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PetRequestBody {

    private String name;
    private LocalDate birthday;
    private PetType petType;
    private Boolean chipped;
    private AccommodationType typeOfAccommodation;
}
