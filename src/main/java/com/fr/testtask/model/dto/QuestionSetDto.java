package com.fr.testtask.model.dto;

import com.fr.testtask.model.AnswerType;
import com.fr.testtask.model.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionSetDto {


    /**
     * {@link Question#getText()}
     */
    private String text;

    /**
     * {@link Question#getAnswerType()}
     */
    private AnswerType answerType;
}
