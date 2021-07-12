package com.fr.testtask.service;

import com.fr.testtask.model.dto.QuestionSetDto;
import com.fr.testtask.model.dto.QuestionViewDto;

import java.util.List;

public interface QuestionService {


    void create(QuestionSetDto question);

    QuestionSetDto update(Long qId, Long pollId);

    void deleteById(Long id);

    List<QuestionViewDto> getAll();

    void editQuestion(QuestionSetDto questionSetDto, Long qId);
}
