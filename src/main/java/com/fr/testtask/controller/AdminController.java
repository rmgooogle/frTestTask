package com.fr.testtask.controller;


import com.fr.testtask.model.dto.*;
import com.fr.testtask.service.AnswerService;
import com.fr.testtask.service.PollService;
import com.fr.testtask.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    private final PollService pollService;
    private final QuestionService questionService;
    private final AnswerService answerService;

    public AdminController(PollService pollService, QuestionService questionService, AnswerService answerService) {
        this.pollService = pollService;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @Operation(summary = "Возвращает все опросы")
    @GetMapping("/poll/all")
    public List<PollDto> getAllPolls() {
        return pollService.getAll();
    }

    @Operation(summary = "Создание опроса")
    @PostMapping("/poll/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPoll(@RequestBody PollDto pollDto) {
        pollService.create(pollDto);
    }

    @Operation(summary = "Редактирование опроса по {id}")
    @PutMapping("/poll/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editPoll(@RequestBody EditPollDto editPollDto, @PathVariable Long id) {
        pollService.update(editPollDto, id);
    }

    @Operation(summary = "удаление опроса по {id}")
    @DeleteMapping("poll/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePoll(@PathVariable Long id) {
        pollService.deleteById(id);
    }

    @Operation(summary = "Возвращает все вопросы")
    @GetMapping("/question/all")
    public List<QuestionViewDto> getAllQuestion() {
        return questionService.getAll();
    }

    @Operation(summary = "Добавление вопроса")
    @PostMapping("/question/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createQuestion(@RequestBody QuestionSetDto questionSetDto) {
        questionService.create(questionSetDto);
    }

    @Operation(summary = "изменение вопроса  по {qId}")
    @PutMapping("/poll/question/{qId}/edit")
    @ResponseStatus(HttpStatus.OK)
    public void editQuestion(@RequestBody QuestionSetDto questionSetDto, @PathVariable Long qId) {
        questionService.editQuestion(questionSetDto, qId);
    }

    @Operation(summary = "Назначение опросу по {pollId} вопроса по {qId}")
    @PutMapping("/poll/{pollId}/question/{qId}/edit")
    @ResponseStatus(HttpStatus.OK)
    public void editQuestionByPollId(@PathVariable Long pollId, @PathVariable Long qId) {
        questionService.update(qId, pollId);
    }

    @Operation(summary = "Удаление вопроса по {id}")
    @DeleteMapping("/question/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteQuestionById(@PathVariable Long id) {
        questionService.deleteById(id);
    }

    @Operation(summary = "Получение ответа по id")
    @GetMapping("/answer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnswerDto getAnswerById(@PathVariable Long id) {
        return answerService.getAnswerById(id);
    }

    @Operation(summary = "Добавление ответа")
    @PostMapping("/answer/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAnswer(@RequestBody AnswerDto answerDto) {
        answerService.create(answerDto);
    }

    @Operation(summary = "Назначение вопросу по {qId} ответа по {id}")
    @PutMapping("/question/{qId}/answer/{id}/edit")
    @ResponseStatus(HttpStatus.OK)
    public void editAnswerBy(@PathVariable Long qId, @PathVariable Long id) {
        answerService.update(qId, id);
    }

    @Operation(summary = "Удаление ответа по {id}")
    @DeleteMapping("/answer/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAnswerById(@PathVariable Long id) {
        answerService.deleteById(id);
    }


}

