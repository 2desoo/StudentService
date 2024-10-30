package student.service.service;

import student.service.model.Student;

import java.util.List;

/**
 * Интерфейс для сервиса работы с сущностями {@link Student}.
 * Этот интерфейс определяет операции, которые могут быть выполнены
 * над студентами, такие как получение списка студентов, добавление,
 * обновление и удаление студентов.
 */
public interface StudentService {
    /**
     * Получает список всех студентов.
     * @return список всех студентов
     */
    List<Student> getAllStudents();

    /**
     * Добавляет нового студента.
     * @param student объект студента, который нужно добавить
     * @return добавленный студент
     */
    Student addStudent(Student student);

    /**
     * Обновляет информацию о студенте по заданному идентификатору.
     * @param id      идентификатор студента, которого нужно обновить
     * @param student объект студента с обновленной информацией
     * @return обновленный студент
     */
    Student updateStudent(Long id, Student student);

    /**
     * Удаляет студента по заданному идентификатору.
     * @param id идентификатор студента, которого нужно удалить
     */
    void deleteStudent(Long id);
}
