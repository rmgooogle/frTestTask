package com.fr.testtask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Класс сущности опроса
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Poll")
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * название опроса
     */
    @Column(name = "name")
    private String name;

    /**
     * описание опроса
     */
    @Column(name = "description")
    private String description;

    /**
     * Дата начала опроса
     */
    @Column(name = "start_date")
    private LocalDate startDate;

    /**
     * Дата окончания опроса
     */
    @Column(name = "end_date")
    private LocalDate endDate;

    /**
     * Принадлежность к вопросам
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poll")
    private Set<Question> questions;

}
