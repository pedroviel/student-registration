package dev.viel.studentregistration.service;

import dev.viel.studentregistration.entity.Student;
import dev.viel.studentregistration.exception.InvalidIdException;
import dev.viel.studentregistration.exception.InvalidMajorException;
import dev.viel.studentregistration.exception.StudentAlreadyEnrolledException;
import dev.viel.studentregistration.exception.StudentNotFoundException;
import dev.viel.studentregistration.exception.StudentNotFoundInCourseException;
import dev.viel.studentregistration.repository.StudentRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @NonNull
    public Student createStudent(Student student) {

        String name = student.getName();
        String course = student.getCourse();

        Student registered = studentRepository.findByNameAndCourse(name, course);

        if(registered != null){
            throw new StudentAlreadyEnrolledException();
        }

        System.out.println(name + " successfully registered!");

        return studentRepository.save(student);
    }

    public void deleteStudent(UUID studentId) {

        if(!studentRepository.existsById(studentId)){
            throw new InvalidIdException();
        }

        String name = studentRepository.findById(studentId).get().getName();

        studentRepository.deleteById(studentId);
        System.out.println(name + " successfully deleted!");
    }

    public List<Student> findStudentsByCourse(String course) {

        if(!studentRepository.existsByCourse(course)){
            throw new InvalidMajorException();
        }

        List<Student> students = studentRepository.findByCourse(course);

        if(students.isEmpty()){
            throw new StudentNotFoundInCourseException();
        }

        return students;
    }

    public Student updateStudentCourse(String name, String course) {

        Student registeredStudent = studentRepository.findByName(name);

        if (Objects.isNull(registeredStudent)) {
            throw new StudentNotFoundException();
        }

        registeredStudent.setCourse(course);

        return studentRepository.save(registeredStudent);
    }

    public Student findById(UUID id) {
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException();
        }

        return studentRepository.findById(id).get();
    }
}
