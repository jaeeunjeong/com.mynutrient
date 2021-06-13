package com.mynutrient.commonService.service;

import com.mynutrient.commonService.domain.Nutrient;
import com.mynutrient.commonService.repository.MemoryNutrientRepository;
import com.mynutrient.commonService.repository.NutrientRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
public class NutrientService {
    private final NutrientRepository nutrientRepository;

    public NutrientService(NutrientRepository nutrientRepository) {
        this.nutrientRepository = nutrientRepository;
    }
    public List<Nutrient> findAll(String sort){
        return nutrientRepository.findAll(sort);
    }

    public Optional<Nutrient> findByWord(String catogory, String word){

        //if("".equals(catogory)) return nutrientRepository.findAll();

        return nutrientRepository.findByIngredient(word);
    }

}
