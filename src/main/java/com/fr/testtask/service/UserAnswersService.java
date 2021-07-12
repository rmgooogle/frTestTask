package com.fr.testtask.service;

import com.fr.testtask.model.dto.PollDto;

import java.util.List;

public interface UserAnswersService {

    List<PollDto> getUserAnswer(Long id);
}
