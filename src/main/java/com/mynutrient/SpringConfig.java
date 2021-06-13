package com.mynutrient;

import com.mynutrient.commonService.repository.MemoryNutrientRepository;
import com.mynutrient.commonService.repository.NutrientRepository;
import com.mynutrient.commonService.service.NutrientService;
import com.mynutrient.community.repository.PostsRepository;
import com.mynutrient.community.service.PostsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public NutrientService nutrientService() {
        return new NutrientService((nutrientRepository() ));
    }
    @Bean
    public NutrientRepository nutrientRepository() {
        return new MemoryNutrientRepository();
    }
}
