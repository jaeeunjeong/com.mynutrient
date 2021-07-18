package com.mynutrient.commonService.controller;

import com.mynutrient.commonService.domain.Nutrient;
import com.mynutrient.commonService.repository.MemoryNutrientRepository;
import com.mynutrient.commonService.service.NutrientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CommonServiceController {

    private final NutrientService nutrientService;
    
    @Autowired
    public CommonServiceController(NutrientService nutrientService){
        this.nutrientService = nutrientService;
    }
    
    @ResponseBody
    @GetMapping(value = "/nutrient/list")
    public String findNutrientAllList(@RequestParam String sort){
        List<Nutrient> nutrientList = nutrientService.findNutrientAllList(sort);
        Model model = new ConcurrentModel();
        model.addAttribute("nutrientList", nutrientList);
        return "nutrients/nutrientList";
    }
    @ResponseBody
    @GetMapping(value = "/nuttrient/search")//{검색 조건}/{word}/{정렬 조건}"
    public String searchNutrientByWord(@RequestParam String category, @RequestParam String word){
        //select * from nutrient where 검색 조건 = word order by 정렬조건;
        Optional<Nutrient> nutrientList = nutrientService.findByWord(category, word);
        Model model;
       // model.addAttribute("nutrientList", nutrientList);
        return "nutrients/nutrientListByWord";
    }


    //post는 RequestBody Nutrient nutrient
}
