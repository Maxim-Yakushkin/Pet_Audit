package com.yakushkin.storage.response.pet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetResponseBody {

    private Optional<?> data;
    private String message;
    private HttpStatus status;
}
