package com.example.project2.surveyapplication.daos;

import com.example.project2.surveyapplication.models.Survey;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
	 @Query("SELECT s FROM Survey s LEFT JOIN FETCH s.questions q LEFT JOIN FETCH q.options WHERE s.surveyId = :surveyId")
	    Optional<Survey> findBySurveyIdWithQuestionsAndOptions(Long surveyId);


	
}
