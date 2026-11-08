package dev.viel.studentregistration.repository;

import dev.viel.studentregistration.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    Student findByNameAndCourse(String name, String course);
    Student findByName(String name);
    List<Student> findByCourse(String course);
    boolean existsByCourse(String course);
}
