package dev.viel.studentregistration.controller;

import dev.viel.studentregistration.controller.dto.StudentDto;
import dev.viel.studentregistration.entity.Student;
import dev.viel.studentregistration.mapper.StudentMapper;
import dev.viel.studentregistration.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody @Valid StudentDto studentDTO) {

        Student student = studentMapper.toEntity(studentDTO);
        Student savedStudent = studentService.createStudent(student);

        return ResponseEntity.accepted().body(studentMapper.toDto(savedStudent));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteStudent(@RequestParam UUID id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> findStudentsByCourse(@RequestParam String course) {

        List<Student> students = studentService.findStudentsByCourse(course);

        return ResponseEntity.ok().body(studentMapper.toDtoList(students));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findStudentById(@PathVariable UUID id) {

        Student student = studentService.findById(id);

        return ResponseEntity.ok().body(studentMapper.toDto(student));
    }

    @PutMapping
    public ResponseEntity<StudentDto> updateStudentCourse(@RequestParam String name, @RequestParam String course) {

        Student student = studentService.updateStudentCourse(name, course);
        return ResponseEntity.accepted().body(studentMapper.toDto(student));
    }
}
