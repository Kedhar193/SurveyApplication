package com.example.project2.surveyapplication.services;

import com.example.project2.surveyapplication.models.Question;


import com.example.project2.surveyapplication.models.Survey;

import jakarta.persistence.EntityNotFoundException;

import com.example.project2.surveyapplication.models.Option;
import com.example.project2.surveyapplication.daos.OptionRepository;
import com.example.project2.surveyapplication.daos.QuestionRepository;
import com.example.project2.surveyapplication.daos.SurveyRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Transactional
    public Survey createSurveyWithQuestionsAndOptions(Survey survey) {
        survey = surveyRepository.save(survey);

        List<Question> savedQuestions = new ArrayList<>();

        for (Question question : survey.getQuestions()) {
            question.setSurvey(survey);
            Question savedQuestion = questionRepository.save(question);
            savedQuestions.add(savedQuestion);

            List<Option> options = question.getOptions();

            for (Option option : options) {
                option.setQuestion(savedQuestion);  // Set the question for each option
                optionRepository.save(option);
            }
        }

        survey.setQuestions(savedQuestions);

        return survey;
    }




    @Transactional(readOnly = true)
    public Survey getSurveyWithDetails(Long surveyId) {
        Optional<Survey> surveyOptional = surveyRepository.findById(surveyId);

        if (surveyOptional.isPresent()) {
            Survey survey = surveyOptional.get();
            survey.getQuestions().size();  // Force initialize the questions
            survey.getQuestions().forEach(question -> question.getOptions().size());  // Force initialize the options
            return survey;
        }

        return null;
    }
     
    
    @Transactional
    public void updateOptionCounts(Long surveyId, Map<Long, Long> selectedOptions) {
        // Retrieve the survey
        Survey survey = surveyRepository.findById(surveyId).orElseThrow(EntityNotFoundException::new);
        
        System.out.println("\n\nselected options in service method :"+selectedOptions+"\n\n");

        // Iterate over the questions
        for (Question question : survey.getQuestions()) {
            Long questionId = question.getQuestionId();
            System.out.println("question id:"+questionId);
            System.out.println("\n\ncondition :"+selectedOptions.containsKey(questionId));
            System.out.println("\n\n"+selectedOptions.keySet());
            
            // Check if the question has a selected option
            if (selectedOptions.containsKey(questionId)) {
                // Update the option count in the question
            	System.out.println("\n\nentering the if block true \n\n");
                question.updateOptionCount(selectedOptions.get(questionId));
            }
        }

        // Save the survey to persist changes
        surveyRepository.save(survey);
    }


}

 
