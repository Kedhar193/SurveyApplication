package com.example.project2.surveyapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.project2.surveyapplication.daos")
public class SurveyapplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyapplicationApplication.class, args);
    }

    
}
