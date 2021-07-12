package com.fr.testtask.model.dto;

import com.fr.testtask.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {

    /**
     * {@link Answer#getId()}
     */
    private Long id;

    /**
     * {@link Answer#getAnswer()}
     */
    private String answer;

    /**
     * {@link Answer#isTrue()}
     */
    private boolean isTrue;

}
