package dev.viel.studentregistration.exception;

public class StudentNotFoundInCourseException extends RuntimeException {
    public StudentNotFoundInCourseException()
    {
        super("Não há alunos cadastrados no curso!");
    }
}
