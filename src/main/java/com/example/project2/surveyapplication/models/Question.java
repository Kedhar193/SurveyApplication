package com.example.project2.surveyapplication.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "questions")
public class Question {
	private static final Logger logger = LoggerFactory.getLogger(Question.class);
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    @JsonBackReference
    private Survey survey;

    @Column(name = "question_text", nullable = false)
    private String questionText;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Option> options = new ArrayList<>();  // Ensure the list is initialized

    // New field to store option counts
    @ElementCollection
    @CollectionTable(name = "question_option_counts", joinColumns = @JoinColumn(name = "question_id"))
    @MapKeyColumn(name = "option_id")
    @Column(name = "count")
    private Map<Long, Integer> optionCounts = new HashMap<>();

    // getters and setters

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Map<Long, Integer> getOptionCounts() {
        return optionCounts;
    }

    public void setOptionCounts(Map<Long, Integer> optionCounts) {
        this.optionCounts = optionCounts;
    }
    public void updateOptionCount(Long selectedOptionIndex) {
        System.out.println("Inside the updateoptioncount method");
        System.out.println(selectedOptionIndex);

        try {
            // Increment the count for the selected option index
            optionCounts.put(selectedOptionIndex, optionCounts.getOrDefault(selectedOptionIndex, 0) + 1);

            // No need to explicitly manage the collection, let Hibernate handle it
            logger.info("Option count updated successfully for questionId: {}", this.getQuestionId());
        } catch (Exception e) {
            logger.error("Error updating option count for questionId: {}", this.getQuestionId(), e);
            throw e; // Rethrow the exception to ensure it's not ignored
        }
    }



}
