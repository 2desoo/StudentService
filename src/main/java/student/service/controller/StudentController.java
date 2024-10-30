package student.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.service.model.Student;
import student.service.service.StudentService;

import java.util.List;

/**
 * Контроллер для работы с сущностью "Студент".
 * Этот контроллер предоставляет API для выполнения CRUD операций над студентами,
 * включая получение списка студентов, добавление нового студента, обновление существующего
 * студента и удаление студента.
 */
@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    /**
     * Получает список всех студентов.
     *
     * @return ResponseEntity с списком студентов и статусом HTTP 200 OK
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = service.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    /**
     * Добавляет нового студента.
     *
     * @param student Объект студента, который нужно добавить
     * @return ResponseEntity с добавленным студентом и статусом HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student newStudent = service.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    /**
     * Обновляет информацию о существующем студенте.
     *
     * @param id Уникальный идентификатор студента, которого нужно обновить
     * @param student Объект студента с новыми данными
     * @return ResponseEntity с обновленным студентом и статусом HTTP 200 OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = service.updateStudent(id, student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    /**
     * Удаляет студента по его идентификатору.
     *
     * @param id Уникальный идентификатор студента, которого нужно удалить
     * @return ResponseEntity с пустым телом и статусом HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
