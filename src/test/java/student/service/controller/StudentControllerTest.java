package student.service.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import student.service.model.Student;
import student.service.service.StudentService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student("Vladimir", "Dubrovsky", "Jr.", "Group A", 4.5);
    }

    @Test
    public void getAllStudents_ShouldReturnListOfStudents() {
        List<Student> students = Arrays.asList(student);
        when(studentService.getAllStudents()).thenReturn(students);

        ResponseEntity<List<Student>> response = studentController.getAllStudents();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(student, response.getBody().get(0));
        verify(studentService, times(1)).getAllStudents();
    }

    @Test
    public void addStudent_ShouldReturnCreatedStudent() {
        when(studentService.addStudent(any(Student.class))).thenReturn(student);

        ResponseEntity<Student> response = studentController.addStudent(student);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(student, response.getBody());
        verify(studentService, times(1)).addStudent(student);
    }

    @Test
    public void updateStudent_ShouldReturnUpdatedStudent() {
        when(studentService.updateStudent(any(Long.class), any(Student.class))).thenReturn(student);

        ResponseEntity<Student> response = studentController.updateStudent(1L, student);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(student, response.getBody());
        verify(studentService, times(1)).updateStudent(1L, student);
    }

    @Test
    public void deleteStudent_ShouldReturnNoContent() {
        ResponseEntity<Void> response = studentController.deleteStudent(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(studentService, times(1)).deleteStudent(1L);
    }
}
