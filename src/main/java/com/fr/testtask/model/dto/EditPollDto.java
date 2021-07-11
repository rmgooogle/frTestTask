package com.fr.testtask.model.dto;

import com.fr.testtask.model.Poll;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditPollDto {

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
}
