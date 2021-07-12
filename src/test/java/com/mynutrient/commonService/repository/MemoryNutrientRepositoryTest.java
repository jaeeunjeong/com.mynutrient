package com.mynutrient.commonService.repository;

import com.mynutrient.commonService.domain.Nutrient;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryNutrientRepositoryTest {

    MemoryNutrientRepository repository = new MemoryNutrientRepository();

    @AfterEach
    public void afterEach() {
        repository.clearNutrientStorage();
    }

    @Test
    void saveNutrient() {
        Nutrient nutrient = new Nutrient();
        nutrient.setIngredientName("vitC");
        nutrient.setIngredientCode(123);
        nutrient.setTakingTime("식전");

        repository.saveNutrient(nutrient);

        //Nutrient result = repository.findByIngredient("vitC", "").get();
        //org.assertj.core.api.Assertions.assertThat(result).isEqualTo(nutrient);
    }

    @Test
    void findByIngredient() {
        Nutrient nutrient1 = new Nutrient();
        nutrient1.setIngredientName("vitC");
        nutrient1.setIngredientCode(123);
        nutrient1.setTakingTime("식전");
        repository.saveNutrient(nutrient1);

        Nutrient nutrient2 = new Nutrient();
        nutrient2.setIngredientName("vitD");
        nutrient2.setIngredientCode(124);
        nutrient2.setTakingTime("식전");
        repository.saveNutrient(nutrient2);

        Nutrient result = repository.findByIngredient("vitC", "").get();

        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(nutrient1);
    }

    @Test
    void findAllOrderbySort() {

        Nutrient nutrient1 = new Nutrient();
        nutrient1.setIngredientName("vitC");
        nutrient1.setIngredientCode(123);
        nutrient1.setTakingTime("식전");
        repository.saveNutrient(nutrient1);

        Nutrient nutrient2 = new Nutrient();
        nutrient2.setIngredientName("vitD");
        nutrient2.setIngredientCode(124);
        nutrient2.setTakingTime("식전");
        repository.saveNutrient(nutrient2);

        List<Nutrient> resultList = repository.findAllOrderbySort("");

        org.assertj.core.api.Assertions.assertThat(resultList.size()).isEqualTo(2);

    }

}