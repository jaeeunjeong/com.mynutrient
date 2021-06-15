package com.mynutrient.commonService.repository;

import com.mynutrient.commonService.domain.Nutrient;

import java.util.List;
import java.util.Optional;

public interface NutrientRepository  {

    Nutrient saveNutrient(Nutrient nutrient);
    Optional<Nutrient> findByIngredient(String word,String sort);
    List<Nutrient> findAllOrderbySort(String sort);
}
