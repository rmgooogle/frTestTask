package com.fr.testtask.service;

import com.fr.testtask.exception.PollNotFoundException;
import com.fr.testtask.model.Poll;
import com.fr.testtask.model.User;
import com.fr.testtask.model.UserAnswers;
import com.fr.testtask.model.dto.EditPollDto;
import com.fr.testtask.model.dto.PollDto;
import com.fr.testtask.model.dto.UserAnsweredDto;
import com.fr.testtask.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PollServiceImpl implements PollService {

    private final PollRepo pollRepo;
    private final UserRepository userRepository;
    private final AnswerRepo answerRepo;
    private final QuestionRepo questionRepo;
    private final UserAnswersRepo userAnswersRepo;
    private final ModelMapper modelMapper;

    public PollServiceImpl(PollRepo pollRepo, UserRepository userRepository,
                           AnswerRepo answerRepo, QuestionRepo questionRepo,
                           UserAnswersRepo userAnswersRepo, ModelMapper modelMapper) {
        this.pollRepo = pollRepo;
        this.userRepository = userRepository;
        this.answerRepo = answerRepo;
        this.questionRepo = questionRepo;
        this.userAnswersRepo = userAnswersRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(PollDto pollDto) {
        pollRepo.save(modelMapper.map(pollDto, Poll.class));
    }

    @Override
    public void update(EditPollDto pollDto, Long pollId) {
        Optional<Poll> pollOptional = pollRepo.findById(pollId);
        if (pollOptional.isEmpty()) {
            throw new PollNotFoundException("Poll not found");
        }
            pollOptional.get().setDescription(pollDto.getDescription());
            pollOptional.get().setEndDate(pollDto.getEndDate());
            pollOptional.get().setStartDate(pollDto.getStartDate());
            pollRepo.save(pollOptional.get());
    }

    @Override
    public void update(List<UserAnsweredDto> userAnsweredDto, Long userId, Long pollId) {
        Optional<Poll> pollOptional = pollRepo.findById(pollId);
        if (pollOptional.isEmpty()) {
            throw new PollNotFoundException("Poll not found");
        }
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("Poll not found");
        }

        userAnsweredDto.stream().forEach(userAnsweredDto1 -> userAnswersRepo.save(new UserAnswers(
                userAnsweredDto1.getId(),
                userAnsweredDto1.getAnswer(),
                userRepository.getById(userId),
                questionRepo.getById(userAnsweredDto1.getQuestionId())
                )));
    }

    @Override
    public void deleteById(Long id) {
            pollRepo.deleteById(id);
    }

    @Override
    public List<PollDto> getAll() {
        return pollRepo.findAll().stream()
                .map(poll -> modelMapper.map(poll , PollDto.class)).collect(Collectors.toList());
    }


    @Override
    public List<PollDto> getActivePoll() {
        return pollRepo.findAll()
                .stream()
                    .filter(i -> i.getStartDate() != null)
                    .collect(Collectors.toList())
                .stream()
                    .filter(j -> j.getEndDate() == null)
                    .collect(Collectors.toList())
                .stream()
                    .map(poll -> modelMapper.map(poll, PollDto.class))
                    .collect(Collectors.toList());
    }

    @Override
    public PollDto getPollById(Long id) {
        return modelMapper.map(pollRepo.getById(id), PollDto.class);
    }

}
