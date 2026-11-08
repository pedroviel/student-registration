package dev.viel.studentregistration.exception;

public class InvalidMajorException extends RuntimeException {
    public InvalidMajorException()
    {
        super("invalid course!");
    }
}
