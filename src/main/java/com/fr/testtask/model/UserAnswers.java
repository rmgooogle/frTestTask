package com.fr.testtask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Класс сущности ответа на вопрос пользователя
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User_Answers")
public class UserAnswers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Вариант ответа пользователя
     */
    @Column(name = "answer")
    private String answer;

    /**
     * Принадлежность к пользователю, ответившему на вопрос
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Принадлежность к вопросов
     */
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
