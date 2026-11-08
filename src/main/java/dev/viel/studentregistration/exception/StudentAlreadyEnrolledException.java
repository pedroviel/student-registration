package dev.viel.studentregistration.exception;

public class StudentAlreadyEnrolledException extends RuntimeException {
    public StudentAlreadyEnrolledException()
    {
        super("Aluno já matriculado no curso!");
    }
}
