package com.fr.testtask.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

/**
 * Класс сущности вопроса
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Текст вопроса
     */
    @Column(name = "text")
    private String text;

    /**
     * Принадлежность к опросам
     */
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "poll_id")
    @NotNull
    private Poll poll;

    /**
     * Принадлежность к ответам, предоставляемым в вопросе
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Set<Answer> answers;

    /**
     * Принадлежность к ответам пользователя
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Set<UserAnswers> userAnswers;

    /**
     * Принадлежность к типам вопросов
     */
    @OneToOne
    @JoinColumn(name = "answerType_id")
    private AnswerType answerType;
}
