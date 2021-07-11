package com.fr.testtask.exception;

public class AnswerNotFoundException extends RuntimeException {
    public AnswerNotFoundException(String question_not_found) {
        super(question_not_found);
    }
}
