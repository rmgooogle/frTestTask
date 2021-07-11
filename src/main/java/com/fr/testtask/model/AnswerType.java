package com.fr.testtask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


/**
 * Класс сущности типа ответа на вопрос
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Answer_type")
@Entity
public class AnswerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Тип ответа
     */
    @Column
    private String answerType;

}
