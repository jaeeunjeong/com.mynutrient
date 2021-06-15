package com.mynutrient;

import com.mynutrient.commonService.repository.MemoryNutrientRepository;
import com.mynutrient.commonService.repository.NutrientRepository;
import com.mynutrient.community.repository.MemoryPostsRepository;
import com.mynutrient.community.repository.PostsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public NutrientRepository nutrientRepository() {
        return new MemoryNutrientRepository(em);
    }

    @Bean
    public PostsRepository postsRepository() {
        return (PostsRepository) new MemoryPostsRepository();
    }
}
