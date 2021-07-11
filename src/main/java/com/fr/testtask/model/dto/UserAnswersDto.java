package com.fr.testtask.model.dto;

import com.fr.testtask.model.UserAnswers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAnswersDto {

    /**
     * {@link UserAnswers#getId()}
     */
    private Long id;

    /**
     * {@link UserAnswers#getAnswer()}
     */
    private String answer;

    /**
     * {@link UserAnswers#getUser()}
     */
    private UserDto user;
}
