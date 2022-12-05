package com.yakushkin.portal.service.pet;

import com.yakushkin.portal.entity.PetEntity;
import com.yakushkin.portal.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PetService {

    private final PetRepository petRepository;

    public List<PetEntity> findAll() {
        return petRepository.findAll();
    }

    public PetEntity findById(Long petId) {
        return petRepository.findById(petId).orElse(null);
    }

    public PetEntity save(PetEntity pet) {
        return petRepository.saveAndFlush(pet);
    }
}
