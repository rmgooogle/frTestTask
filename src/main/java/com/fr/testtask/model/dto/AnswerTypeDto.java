package com.fr.testtask.model.dto;

import com.fr.testtask.model.AnswerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerTypeDto {

    /**
     * {@link AnswerType#getId()}
     */
    private Long id;

    /**
     * {@link AnswerType#getAnswerType()}
     */
    private String answerType;
}
