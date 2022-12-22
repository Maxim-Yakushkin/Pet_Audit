package com.yakushkin.portal.response.pet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

// TODO: 22.12.2022 Adjusting is needed
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetResponseBody {

    //    private PetEntity data;
    private String message;
}
