package dev.viel.studentregistration.exception;

public class StudentNotFoundInCourseException extends RuntimeException {
    public StudentNotFoundInCourseException()
    {
        super("there are nos students enrolled in the course!");
    }
}
