package dev.viel.studentregistration.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException()
    {
        super("student not found!");
    }
}
