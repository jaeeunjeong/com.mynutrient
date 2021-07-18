package com.mynutrient.commonService.service;

import com.mynutrient.commonService.domain.Nutrient;
import com.mynutrient.commonService.repository.MemoryNutrientRepository;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class NutrientServiceTest {

    NutrientService nutrientService;
    MemoryNutrientRepository nutrientRepository;

    @BeforeEach
    public  void beforeEach() {
        nutrientRepository = new MemoryNutrientRepository();
        nutrientService = new NutrientService(nutrientRepository);
    }

    @AfterEach
    public void afterEach() {
        nutrientRepository.clearNutrientStorage();
    }

    @Test
    public void 영양제_정보_저장하기() throws Exception {
        Nutrient nutrient = new Nutrient();
        nutrient.setIngredientCode(123);
        nutrient.setIngredientName("vitaC");
        nutrient.setTakingTime("식후");

        Long savdId = nutrientService.saveNutrient(nutrient);

       // Nutrient result = nutrientRepository.findByIngredient("")

    }

    @Test
    void 영양제_전체_리스트_가져오기() {
        Nutrient nutrient1 = new Nutrient();
        nutrient1.setIngredientCode(123);
        nutrient1.setIngredientName("vitaC");
        nutrient1.setTakingTime("식후");
        Nutrient nutrient2 = new Nutrient();
        nutrient2.setIngredientCode(133);
        nutrient2.setIngredientName("vitaD");
        nutrient2.setTakingTime("식중");

        nutrientService.saveNutrient(nutrient1);
        nutrientService.saveNutrient(nutrient2);
        List<Nutrient> resultList = nutrientService.findNutrientAllList("");

        //list 검증을 어떻게 할 것인가...

    }

    @Test
    void 영양제_검색하기() {
        Nutrient nutrient1 = new Nutrient();
        nutrient1.setIngredientCode(123);
        nutrient1.setIngredientName("vitaC");
        nutrient1.setTakingTime("식후");
        Nutrient nutrient2 = new Nutrient();
        nutrient2.setIngredientCode(133);
        nutrient2.setIngredientName("vitaD");
        nutrient2.setTakingTime("식중");

        nutrientService.saveNutrient(nutrient1);
        nutrientService.saveNutrient(nutrient2);

        Optional<Nutrient> result = nutrientService.findByWord("name", "vitaC");
        org.assertj.core.api.Assertions.assertThat(result.equals(nutrient1));//테스트 케이스가 이상함
    }
}