package CODE;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private List<Assignment> submittedAssignments;

    public Student(String studentId) {
        this.studentId = studentId;
        this.submittedAssignments = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public void submitAssignment(Assignment assignment) {
        submittedAssignments.add(assignment);
    }
}

