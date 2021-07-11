package com.fr.testtask.service;

import com.fr.testtask.model.dto.PollDto;

import java.util.Set;

public interface UserAnswersService {

    Set<PollDto> getUserAnswer(Long id);
}
