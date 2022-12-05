package com.yakushkin.portal.response.pet;

import com.yakushkin.portal.entity.PetEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetResponseBody {

    private PetEntity data;
    private String message;
}
