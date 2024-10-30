package student.service.model;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Представляет студента в учебном заведении.
 * Содержит информацию о студенте, такую как имя, фамилия, отчество,
 * группа и средняя оценка.
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String patronymic;
    private String studentGroup;
    private double averageGrade;

    public Student() {}

    public Student(String fistName, String lastName, String patronymic, String studentGroup, double averageGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.studentGroup = studentGroup;
        this.averageGrade = averageGrade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", studentGroup='" + studentGroup + '\'' +
                ", averageGrade=" + averageGrade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(averageGrade, student.averageGrade) == 0 && Objects.equals(id, student.id) && Objects.equals(lastName, student.lastName) && Objects.equals(firstName, student.firstName) && Objects.equals(patronymic, student.patronymic) && Objects.equals(studentGroup, student.studentGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, patronymic, studentGroup, averageGrade);
    }
}

