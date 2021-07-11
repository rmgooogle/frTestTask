package com.fr.testtask.model.dto;

import com.fr.testtask.model.AnswerType;
import com.fr.testtask.model.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionViewDto {
    /**
     * {@link Question#getId()}
     */
    private Long id;

    /**
     * {@link Question#getText()}
     */
    private String text;

    /**
     * {@link Question#getAnswerType()}
     */
    private AnswerType answerType;

    /**
     * /*  {@link Question#getAnswers()}
     */
    private Set<AnswerDto> answers;

    /**
     * {@link Question#getUserAnswers()}
     */
    private Set<UserAnswersDto> userAnswers;
}
