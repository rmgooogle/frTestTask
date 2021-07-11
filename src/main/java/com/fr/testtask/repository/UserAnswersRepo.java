package com.fr.testtask.repository;

import com.fr.testtask.model.UserAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserAnswersRepo extends JpaRepository<UserAnswers, Long> {
}
