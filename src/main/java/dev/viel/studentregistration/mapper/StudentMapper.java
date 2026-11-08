package dev.viel.studentregistration.mapper;

import dev.viel.studentregistration.controller.dto.StudentDto;
import dev.viel.studentregistration.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentMapper {

    public StudentDto toDto(Student student) {

        return new StudentDto(student.getId(), student.getName(), student.getCourse());
    }

    public List<StudentDto> toDtoList(List<Student> students) {

        if(students == null) {
            return null;
        }

        return students.stream().map(this::toDto).toList();
    }

    public Student toEntity(StudentDto dto) {

        if(dto == null) {
            return null;
        }

        return new Student(dto.id(), dto.name(), dto.course());
    }
}
