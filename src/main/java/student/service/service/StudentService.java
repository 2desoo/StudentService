package student.service.service;

import student.service.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student addStudent(Student student);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}
