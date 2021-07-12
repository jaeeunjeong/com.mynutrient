package com.mynutrient.commonService.repository;

import com.mynutrient.commonService.domain.Nutrient;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.persistence.EntityManager;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryNutrientRepository implements NutrientRepository {

    private static Map<Long, Nutrient> nutrientStorege = new ConcurrentHashMap<>();
    private static long sequence = 0L;//DB에서 올려주도록 할 것

    @Override
    public Nutrient saveNutrient(Nutrient nutrient) {
        nutrient.setNutrient_seq_id(++sequence);
        nutrientStorege.put(nutrient.getNutrient_seq_id(), nutrient);
        return nutrient;
    }

    @Override
    public Optional<Nutrient> findByIngredient(String ingredient, String sort) {
        //return Optional.ofNullable(nutrientStorege.get(ingredient));//단순 유일값 조회
        return nutrientStorege.values().stream()
                .filter(nutrient -> nutrient.getIngredientName().equals(ingredient))
                .findAny();
    }

    @Override
    public List<Nutrient> findAllOrderbySort(String sort) {
        return new ArrayList<>(nutrientStorege.values());
    }

    public void clearNutrientStorage() {
        nutrientStorege.clear();
    }
}
