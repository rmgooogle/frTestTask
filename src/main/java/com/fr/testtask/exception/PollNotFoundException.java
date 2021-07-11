package com.fr.testtask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PollNotFoundException extends RuntimeException {
    public PollNotFoundException(String poll_not_found) {
        super(poll_not_found);
    }
}
