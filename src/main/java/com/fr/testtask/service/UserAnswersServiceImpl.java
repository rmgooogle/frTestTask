package com.fr.testtask.service;

import com.fr.testtask.model.dto.PollDto;
import com.fr.testtask.repository.PollRepo;
import com.fr.testtask.repository.UserAnswersRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public Set<PollDto> getUserAnswer(Long id) {
        return userAnswersRepo.findAll().stream().filter(x -> x.getUser().getId().equals(id)).
                map(x -> x.getQuestion().getPoll()).collect(Collectors.toSet())
                .stream().map(x -> modelMapper.map(x, PollDto.class)).collect(Collectors.toSet());

    }

}
