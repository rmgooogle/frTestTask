package com.fr.testtask.service;

import com.fr.testtask.model.dto.AnswerDto;

public interface AnswerService {

    void create(AnswerDto answerDto);

    void update(Long questionId, Long answerId);

    void deleteById(Long id);
}
