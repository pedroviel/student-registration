package dev.viel.studentregistration.exception;

public class StudentAlreadyEnrolledException extends RuntimeException {
    public StudentAlreadyEnrolledException()
    {
        super("student already enrolled!");
    }
}
