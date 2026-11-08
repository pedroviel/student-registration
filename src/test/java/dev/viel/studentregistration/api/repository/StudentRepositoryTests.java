package dev.viel.studentregistration.api.repository;

import dev.viel.studentregistration.entity.Student;
import dev.viel.studentregistration.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class StudentRepositoryTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void findByNameAndCourse_shouldReturnStudentFiltered() {

        //Arrange
        Student student = Student.builder()
                .name("Pedro")
                .course("Engenharia da Computação").build();

        //Act
        studentRepository.save(student);
        Student studentFiltered = studentRepository.findByNameAndCourse(student.getName(), student.getCourse());

        //Assert
        Assertions.assertThat(studentFiltered.getName()).isEqualTo("Pedro");
        Assertions.assertThat(studentFiltered.getCourse()).isEqualTo("Engenharia da Computação");
    }

    @Test
    public void findByName_shouldReturnStudentFiltered() {

        //Arrange
        Student student = Student.builder()
                .name("Pedro")
                .course("Engenharia da Computação").build();

        //Act
        studentRepository.save(student);
        Student studentFiltered = studentRepository.findByName(student.getName());

        //Assert
        Assertions.assertThat(studentFiltered).isNotNull();
        Assertions.assertThat(studentFiltered.getName()).isEqualTo("Pedro");
        Assertions.assertThat(studentFiltered.getCourse()).isEqualTo("Engenharia da Computação");
    }

    @Test
    public void findById_shouldReturnStudentFiltered() {

        //Arrange
        Student student = Student.builder()
                .name("Pedro")
                .course("Engenharia da Computação").build();

        //Act
        studentRepository.save(student);
        Optional<Student> studentFiltered = studentRepository.findById(student.getId());

        //Assert
        Assertions.assertThat(studentFiltered).isNotNull();
        Assertions.assertThat(studentFiltered.get().getName()).isEqualTo("Pedro");
        Assertions.assertThat(studentFiltered.get().getCourse()).isEqualTo("Engenharia da Computação");
    }

    @Test
    public void findByCourse_shouldReturnOnlyStudentsFiltered() {

        //Arrange
        Student student = Student.builder()
                .name("Pedro")
                .course("Engenharia da Computação").build();
        Student student2 = Student.builder()
                .name("Pedro")
                .course("Engenharia da Computação").build();

        //Act
        studentRepository.save(student);
        studentRepository.save(student2);
        List<Student> studentsOnCourse = studentRepository.findByCourse(student.getCourse());

        //Assert
        Assertions.assertThat(studentsOnCourse).isNotNull();
        Assertions.assertThat(studentsOnCourse.get(0).getName()).isEqualTo("Pedro");
        Assertions.assertThat(studentsOnCourse.get(0).getCourse()).isEqualTo("Engenharia da Computação");
    }

    @Test
    public void existsByCourse_shouldReturnTrue() {

        //Arrange
        Student student = Student.builder()
                .name("Pedro")
                .course("Engenharia da Computação").build();

        //Act
        studentRepository.save(student);
        boolean courseExists = studentRepository.existsByCourse(student.getCourse());

        //Assert
        Assertions.assertThat(courseExists).isTrue();
    }
}
