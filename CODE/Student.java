package CODE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
    private String studentId;
    private Set<Assignment> submittedAssignments;

    public Student(String studentId) {
        this.studentId = studentId;
        this.submittedAssignments = new HashSet<>();
    }

    public String getStudentId() {

        return studentId;
    }

    public boolean submitAssignment(Assignment assignment) {
        return submittedAssignments.add(assignment);
    }
    public boolean isAssignment(Assignment assignment){
        return submittedAssignments.contains(assignment);
    }

}

