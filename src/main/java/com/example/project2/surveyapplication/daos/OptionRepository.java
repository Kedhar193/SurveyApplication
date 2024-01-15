  package com.example.project2.surveyapplication.daos;

import com.example.project2.surveyapplication.models.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findByQuestionQuestionId(Long questionId);

    // Add custom queries if needed
    boolean existsByQuestionQuestionIdAndOptionText(Long questionId, String optionText);
}
