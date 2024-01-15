package com.example.project2.surveyapplication.daos;

import com.example.project2.surveyapplication.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	List<Question> findBySurvey_SurveyId(Long surveyId);

    
    boolean existsBySurvey_SurveyIdAndQuestionText(Long surveyId, String questionText);
}
