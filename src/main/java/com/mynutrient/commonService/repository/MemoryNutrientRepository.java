package com.mynutrient.commonService.repository;

import com.mynutrient.commonService.domain.Nutrient;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.persistence.EntityManager;
import java.util.*;

public class MemoryNutrientRepository implements NutrientRepository {

    private final EntityManager em;

    public MemoryNutrientRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Nutrient saveNutrient(Nutrient nutrient) {
        em.persist(nutrient);
        return nutrient;
    }

    @Override
    public Optional<Nutrient> findByIngredient(String ingredient, String sort) {
        Nutrient nutrient = em.find(Nutrient.class, ingredient);
        return Optional.ofNullable(nutrient);
    }

    @Override
    public List<Nutrient> findAllOrderbySort(String sort) {
        return null;
    }
}
