package com.fr.testtask.service;

import com.fr.testtask.model.dto.PollDto;
import com.fr.testtask.repository.UserAnswersRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserAnswersServiceImpl implements UserAnswersService {

    private final UserAnswersRepo userAnswersRepo;
    private final ModelMapper modelMapper;


    public UserAnswersServiceImpl(UserAnswersRepo userAnswersRepo, ModelMapper modelMapper) {
        this.userAnswersRepo = userAnswersRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PollDto> getUserAnswer(Long userId) {
        return userAnswersRepo.findAll().stream()
                .filter(userAnswer -> userAnswer.getUser().getId().equals(userId))
                .map(answer -> answer.getQuestion().getPoll())
                .distinct()
                .map(poll -> modelMapper.map(poll, PollDto.class))
                .collect(Collectors.toList());
    }

}
