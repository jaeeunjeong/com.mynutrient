package com.mynutrient.commonService.service;

import com.mynutrient.commonService.domain.Nutrient;
import com.mynutrient.commonService.repository.MemoryNutrientRepository;
import com.mynutrient.commonService.repository.NutrientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class NutrientService {
    private final NutrientRepository nutrientRepository;

    public NutrientService(NutrientRepository nutrientRepository) {
        this.nutrientRepository = nutrientRepository;
    }

    public List<Nutrient> findAll(String sort){
        return nutrientRepository.findAllOrderbySort(sort);
    }

    public Optional<Nutrient> findByWord(String catogory, String word){
        return nutrientRepository.findByIngredient(catogory, word);
    }

}
