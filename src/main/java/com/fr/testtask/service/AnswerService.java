package com.fr.testtask.service;

import com.fr.testtask.model.dto.AnswerDto;

import java.util.List;

public interface AnswerService {

    List<AnswerDto> getAll();

    AnswerDto getAnswersById(Long id);

    void create(AnswerDto answerDto);

    void update(Long questionId, Long answerId);

    void deleteById(Long id);
}
