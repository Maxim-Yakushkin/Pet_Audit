package com.yakushkin.storage.service.pet;

import com.yakushkin.storage.entity.PetEntity;
import com.yakushkin.storage.mapper.PetMapper;
import com.yakushkin.storage.repository.PetRepository;
import com.yakushkin.storage.request.pet.PetRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public Optional<PetEntity> update(Long petId, PetRequestBody petRequestBody) {
        return petRepository.findById(petId)
                .map(pet -> PetMapper.mergeRequestBodyToEntity(petRequestBody, pet))
                .map(petRepository::saveAndFlush);
    }

    public boolean delete(Long petId) {
        return petRepository.findById(petId)
                .map(petEntity -> {
                    petRepository.delete(petEntity);
                    petRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
