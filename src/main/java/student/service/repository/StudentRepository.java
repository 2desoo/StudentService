package student.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.service.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
