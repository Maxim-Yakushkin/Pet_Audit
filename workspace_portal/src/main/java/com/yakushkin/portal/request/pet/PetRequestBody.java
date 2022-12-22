package com.yakushkin.portal.request.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

// TODO: 22.12.2022 Adjusting is needed
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PetRequestBody {

    private String name;
    private LocalDate birthday;
    //    private PetType petType;
    private Boolean chipped;
//    private AccommodationType typeOfAccommodation;
}
