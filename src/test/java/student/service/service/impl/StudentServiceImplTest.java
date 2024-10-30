package student.service.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import student.service.model.Student;
import student.service.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        student = new Student("Doe", "John", "Jr.", "Group A", 3.5);
    }

    @Test
    public void getAllStudents_ShouldReturnListOfStudents() {
        // Arrange
        List<Student> students = new ArrayList<>();
        students.add(student);
        when(studentRepository.findAll()).thenReturn(students);

        // Act
        List<Student> result = studentService.getAllStudents();

        // Assert
        assertEquals(1, result.size());
        assertEquals(student, result.get(0));
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void addStudent_ShouldReturnSavedStudent() {
        // Arrange
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        // Act
        Student result = studentService.addStudent(student);

        // Assert
        assertEquals(student, result);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void updateStudent_ShouldReturnUpdatedStudent() {
        // Arrange
        student.setId(1L);
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        // Act
        Student result = studentService.updateStudent(1L, student);

        // Assert
        assertEquals(student, result);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void deleteStudent_ShouldCallDeleteById() {
        // Act
        studentService.deleteStudent(1L);

        // Assert
        verify(studentRepository, times(1)).deleteById(1L);
    }
}
