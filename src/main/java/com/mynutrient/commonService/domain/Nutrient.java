package com.mynutrient.commonService.domain;

public class Nutrient {
    private Long nutrient_seq_id;
    private String ingredientName;
    private String takingTime;//int로 바꾸면 좋을 것 같음.
    private int ingredientCode;

    public Long getNutrient_seq_id() {
        return nutrient_seq_id;
    }

    public void setNutrient_seq_id(Long nutrient_seq_id) {
        this.nutrient_seq_id = nutrient_seq_id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getTakingTime() {
        return takingTime;
    }

    public void setTakingTime(String takingTime) {
        this.takingTime = takingTime;
    }

    public int getIngredientCode() {
        return ingredientCode;
    }

    public void setIngredientCode(int ingredientCode) {
        this.ingredientCode = ingredientCode;
    }
}
