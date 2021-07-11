package com.fr.testtask.exception;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException(String question_not_found) {
        super(question_not_found);
    }
}
