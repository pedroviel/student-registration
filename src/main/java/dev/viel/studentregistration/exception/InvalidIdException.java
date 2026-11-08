package dev.viel.studentregistration.exception;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException()
    {
        super("invalid ID!");
    }
}
