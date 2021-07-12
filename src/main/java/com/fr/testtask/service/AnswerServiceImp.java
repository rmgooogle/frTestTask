package com.fr.testtask.service;

import com.fr.testtask.exception.AnswerNotFoundException;
import com.fr.testtask.exception.PollIsStartException;
import com.fr.testtask.exception.QuestionNotFoundException;
import com.fr.testtask.model.Answer;
import com.fr.testtask.model.Question;
import com.fr.testtask.model.dto.AnswerDto;
import com.fr.testtask.repository.AnswerRepo;
import com.fr.testtask.repository.QuestionRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerServiceImp implements AnswerService {

    private final AnswerRepo answerRepo;
    private final ModelMapper modelMapper;
    private final QuestionRepo questionRepo;

    public AnswerServiceImp(AnswerRepo answerRepo, ModelMapper modelMapper, QuestionRepo questionRepo) {
        this.answerRepo = answerRepo;
        this.modelMapper = modelMapper;
        this.questionRepo = questionRepo;
    }

    @Override
    public AnswerDto getAnswerById(Long id) {
        Optional<Answer> answerOptional = answerRepo.findById(id);
        if (answerOptional.isEmpty()) {
            throw new AnswerNotFoundException("Answer not found");
        }
        return modelMapper.map(answerOptional.get(), AnswerDto.class);
    }

    @Override
    public void create(AnswerDto answerDto) {
        answerRepo.save(modelMapper.map(answerDto, Answer.class));
    }

    @Override
    public void update(Long questionId, Long answerId) {
        Optional<Question> questionOptional = questionRepo.findById(questionId);
        if (questionOptional.isEmpty()) {
            throw new QuestionNotFoundException("Question not found");
        }
        Optional<Answer> answerOptional = answerRepo.findById(answerId);
        if (answerOptional.isEmpty()) {
            throw new AnswerNotFoundException("Question not found");
        }
        Question question = questionOptional.get();
        Answer answer = answerOptional.get();

        if ((question.getPoll() == null || question.getPoll().getStartDate() == null)
                &&
                (answer.getQuestion() == null
                        || answer.getQuestion().getPoll() == null
                        || answer.getQuestion().getPoll().getStartDate() == null)) {
            answer.setQuestion(question);
            answerRepo.save(answer);
        } else throw new PollIsStartException("Poll is started");
    }

    @Override
    public void deleteById(Long id) {
        if (answerRepo.getById(id).getQuestion().getPoll().getStartDate() == null) {
            answerRepo.deleteById(id);
        } else throw new PollIsStartException("Poll is started");
    }
}
