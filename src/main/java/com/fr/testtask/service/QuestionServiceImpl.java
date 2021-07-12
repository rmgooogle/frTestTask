package com.fr.testtask.service;

import com.fr.testtask.exception.PollIsStartException;
import com.fr.testtask.exception.PollNotFoundException;
import com.fr.testtask.exception.QuestionNotFoundException;
import com.fr.testtask.model.Poll;
import com.fr.testtask.model.Question;
import com.fr.testtask.model.dto.QuestionSetDto;
import com.fr.testtask.model.dto.QuestionViewDto;
import com.fr.testtask.repository.PollRepo;
import com.fr.testtask.repository.QuestionRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepo questionRepo;
    private final PollRepo pollRepo;
    private final ModelMapper modelMapper;

    public QuestionServiceImpl(QuestionRepo questionRepo, PollRepo pollRepo, ModelMapper modelMapper) {
        this.questionRepo = questionRepo;
        this.pollRepo = pollRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(QuestionSetDto questionSetDto) {
        questionRepo.save(modelMapper.map(questionSetDto, Question.class));
    }

    @Override
    public QuestionSetDto update(Long qId, Long pollId) {
        Optional<Question> questionOptional = questionRepo.findById(qId);
        if (questionOptional.isEmpty()) {
            throw new QuestionNotFoundException("Question not found");
        }
        Optional<Poll> pollOptional = pollRepo.findById(pollId);
        if (pollOptional.isEmpty()) {
            throw new PollNotFoundException("Poll not found");
        }
        if ((pollOptional.get().getStartDate() != null) && (questionOptional.get().getPoll().getStartDate() == null)) {
            throw new PollIsStartException("Poll is started");
        } else {
            questionOptional.get().setPoll(pollOptional.get());
            questionRepo.save(questionOptional.get());
        }
        return modelMapper.map(questionOptional.get(), QuestionSetDto.class);
    }

    @Override
    public void deleteById(Long id) {
        if (questionRepo.getById(id).getPoll().getStartDate() == null)
            questionRepo.deleteById(id);
        else throw new PollIsStartException("Poll is started");
    }

    @Override
    public List<QuestionViewDto> getAll() {
        return questionRepo.findAll().stream()
                .map(question -> modelMapper.map(question, QuestionViewDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public void editQuestion(QuestionSetDto questionSetDto, Long qId) {
        Optional<Question> questionOptional = questionRepo.findById(qId);
        if (questionOptional.isEmpty()) {
            throw new QuestionNotFoundException("Question not found");
        }
        questionOptional.get().setText(questionSetDto.getText());
        questionOptional.get().setAnswerType(questionSetDto.getAnswerType());

        questionRepo.save(questionOptional.get());
    }
}
