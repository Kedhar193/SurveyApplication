package com.example.project2.surveyapplication.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project2.surveyapplication.models.GoogleSignInDTO;

@Repository
public interface UserRepositoryGoogle extends JpaRepository<GoogleSignInDTO, String> {
    // Additional query methods if needed
}
