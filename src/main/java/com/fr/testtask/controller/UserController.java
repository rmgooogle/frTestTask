package com.fr.testtask.controller;

import com.fr.testtask.model.dto.PollDto;
import com.fr.testtask.model.dto.UserAnsweredDto;
import com.fr.testtask.service.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final PollService pollService;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserAnswersService userAnswersService;
    private final UserService userService;

    public UserController(PollService pollService, QuestionService questionService, AnswerService answerService, UserAnswersService userAnswersService, UserService userService) {
        this.pollService = pollService;
        this.questionService = questionService;
        this.answerService = answerService;
        this.userAnswersService = userAnswersService;
        this.userService = userService;
    }

    @Operation(summary = "Получение анонимному пользвателю {id} и перессылка на все опросы")
    @GetMapping("/anon")
    public RedirectView saveAnonUser() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/user/anon/" + userService.saveAnonUser() + "/poll/all");
        return redirectView;
    }

    //TODO check user by id
    @Operation(summary = "получение анонимному пользователю всех опросов")
    @GetMapping("/anon/{id}/poll/all")
    public List<PollDto> getAllPollForAnonymous(@PathVariable Long id) {
        return pollService.getAll();
    }

    //TODO check user by id
    @Operation(summary = "Получение анонимному пользователю опроса по pollId")
    @GetMapping("/anon/{id}/poll/{pollId}")
    public PollDto getAllPollForAnonymous(@PathVariable Long id, @PathVariable Long pollId) {
        return pollService.getPollById(pollId);
    }

    @Operation(summary = "полученные ответы на вопрос с id = userAnsweredDto.questionId()," +
            " анонимного пользователя с userId, опроса с id=pollId")
    @PostMapping("/anon/{userId}/poll/{pollId}/answered")
    public void putAnswersAnonymous(@RequestBody List<UserAnsweredDto> userAnsweredDto, @PathVariable Long userId, @PathVariable Long pollId) {
        pollService.update(userAnsweredDto, userId, pollId);
    }

    @Operation(summary = "полученные ответы на вопрос с id = userAnsweredDto.questionId()," +
            " пользователя с userId, опроса с id=pollId")
    @PostMapping("/{userId}/poll/{pollId}/answered")
    public void putAnswers(@RequestBody List<UserAnsweredDto> userAnsweredDto, @PathVariable Long userId, @PathVariable Long pollId) {
        pollService.update(userAnsweredDto, userId, pollId);
    }

    @Operation(summary = "Получение всех опросов авторизированному пользователю")
    @GetMapping("/poll/all")
    public List<PollDto> getAllPoll() {
        return pollService.getAll();
    }

    @Operation(summary = "Получение опроса по id авторизированному пользователю")
    @GetMapping("/poll/{id}")
    public PollDto getPollById(@PathVariable Long id) {
        return pollService.getPollById(id);
    }

    @Operation(summary = "Получение всех активных опросов авторизированному пользователю")
    @GetMapping("/poll/active")
    public List<PollDto> getActivePoll() {
        return pollService.getActivePoll();
    }

    @Operation(summary = "Получение всех опросов с ответами авторизированного пользователя с {userId}")
    @GetMapping("/{userId}/answers")
    public List<PollDto> getUserAnswerById(@PathVariable Long userId) {
        return userAnswersService.getUserAnswer(userId);
    }
}
