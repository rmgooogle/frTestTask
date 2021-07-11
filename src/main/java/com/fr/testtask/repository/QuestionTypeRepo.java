package com.fr.testtask.repository;


import com.fr.testtask.model.AnswerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTypeRepo extends JpaRepository<AnswerType, Long> {
}
