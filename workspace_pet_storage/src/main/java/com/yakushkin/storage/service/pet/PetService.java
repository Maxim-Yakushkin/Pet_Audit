package com.yakushkin.storage.service.pet;

import com.yakushkin.storage.entity.PetEntity;
import com.yakushkin.storage.repository.PetRepository;
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
