package com.fr.testtask.exception;

public class PollIsStartException extends RuntimeException {
    public PollIsStartException(String poll_is_started) {
        super(poll_is_started);
    }
}
