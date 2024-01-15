package com.example.project2.surveyapplication.controllers;



import com.example.project2.surveyapplication.models.Survey;







import com.example.project2.surveyapplication.services.SurveyService;


import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import org.json.JSONArray;
import org.json.JSONObject;


@RestController
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> createSurvey(@RequestBody Survey survey) {
        // Call the service method to create survey with questions and options
        Survey createdSurvey = surveyService.createSurveyWithQuestionsAndOptions(survey);

        // Return the created survey
        return ResponseEntity.ok(createdSurvey);
    }
    
    @GetMapping("/{surveyId:\\d+}")
    public ModelAndView getSurveyDetails(@PathVariable Long surveyId) {
        Survey survey = surveyService.getSurveyWithDetails(surveyId);

        ModelAndView modelAndView = new ModelAndView();

        if (survey != null) {
            modelAndView.addObject("survey", survey);
            modelAndView.setViewName("survey");
        } else {
            modelAndView.setViewName("surveyNotFound");
        }

        return modelAndView;
    }
   
    @PostMapping("/submit/{surveyId}")
    public ResponseEntity<String> submitSurvey(@PathVariable Long surveyId, @RequestParam Map<String, String> requestParams) {
        Map<Long, Long> selectedOptions = new HashMap<>();

        // Log input data
        System.out.println("Received surveyId: " + surveyId);
        System.out.println("Received requestParams: " + requestParams);

        // Extract selected options from the request parameters
        if (requestParams.containsKey("selectedOptions")) {
            String selectedOptionsJson = requestParams.get("selectedOptions");

            // Parse the JSON string
            JSONArray jsonArray = new JSONArray(selectedOptionsJson);

            // Convert the JSON array to the desired structure
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject optionObject = jsonArray.getJSONObject(i);
                Long questionId = Long.parseLong(optionObject.getString("questionId"));
                Long selectedOptionIndex = Long.parseLong(optionObject.getString("selectedOptionIndex"));
                selectedOptions.put(questionId, selectedOptionIndex);
            }
        }

        // Log selectedOptions
        System.out.println("Extracted selectedOptions: " + selectedOptions);

        // Update option counts in the database
        surveyService.updateOptionCounts(surveyId, selectedOptions);

        // Return a ResponseEntity with a success message
        return new ResponseEntity<>("Survey submitted successfully", HttpStatus.OK);
    }

}






  