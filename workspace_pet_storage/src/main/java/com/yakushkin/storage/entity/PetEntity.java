package com.yakushkin.storage.entity;

import com.yakushkin.storage.entity.enumiration.AccommodationType;
import com.yakushkin.storage.entity.enumiration.PetType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "pet")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PetType petType;

    private Boolean chipped;

    @Enumerated(EnumType.STRING)
    private AccommodationType typeOfAccommodation;
}
