package CODE;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private String name;
    private List<Student> students;
    private List<Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudent(String studentId) {
        return students.stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst()
                .orElse(null);
    }

    public void scheduleAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
}

