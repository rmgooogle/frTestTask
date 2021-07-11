package com.fr.testtask.service;

import com.fr.testtask.model.dto.EditPollDto;
import com.fr.testtask.model.dto.PollDto;
import com.fr.testtask.model.dto.UserAnsweredDto;

import java.util.List;

public interface PollService {

    void create(PollDto pollDto);

    void update(EditPollDto pollDto, Long pollId);

    void update(List<UserAnsweredDto> userAnsweredDto, Long userId, Long pollId);

    void deleteById(Long id);

    List<PollDto> getAll();

    List<PollDto> getActivePoll();

    PollDto getPollById(Long id);

}
