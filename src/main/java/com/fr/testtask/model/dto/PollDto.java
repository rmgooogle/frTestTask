package com.fr.testtask.model.dto;

import com.fr.testtask.model.Poll;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PollDto {

    /**
     * {@link Poll#getId()}
     */
    private Long id;

    /**
     * {@link Poll#getName()}
     */
    private String name;

    /**
     * {@link Poll#getDescription()}
     */
    private String description;

    /**
     * {@link Poll#getStartDate()}
     */
    private LocalDate startDate;

    /**
     * {@link Poll#getEndDate()} )}
     */
    private LocalDate endDate;

    /**
     * {@link Poll#getQuestions()}
     */
    private Set<QuestionViewDto> questions;
}
