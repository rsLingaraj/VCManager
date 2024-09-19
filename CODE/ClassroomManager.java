package CODE;

import java.util.HashMap;
import java.util.Map;

public class ClassroomManager {
    private static ClassroomManager instance;
    private Map<String, Classroom> classrooms;
    private Logger logger;

    private ClassroomManager() {
        classrooms = new HashMap<>();
        logger = new ConsoleLogger();
    }

    public static ClassroomManager getInstance() {
        if (instance == null) {
            instance = new ClassroomManager();
        }
        return instance;
    }

    public void addClassroom(String name) {
        if (!classrooms.containsKey(name)) {
            classrooms.put(name, new Classroom(name));
            logger.log("Classroom " + name + " has been created.");
        } else {
            logger.log("Classroom " + name + " already exists.");
        }
    }

    public void addStudent(String studentId, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.addStudent(new Student(studentId));
            logger.log("Student " + studentId + " has been enrolled in " + className + ".");
        } else {
            logger.log("Classroom " + className + " not found.");
        }
    }

    public void scheduleAssignment(String className, String assignmentDetails) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            Assignment assignment = new Assignment(assignmentDetails);
            classroom.scheduleAssignment(assignment);
            logger.log("Assignment for " + className + " has been scheduled.");
        } else {
            logger.log("Classroom " + className + " not found.");
        }
    }

    public void submitAssignment(String studentId, String className, String assignmentDetails) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            Student student = classroom.getStudent(studentId);
            if (student != null) {
                Assignment assignment = new Assignment(assignmentDetails);
                student.submitAssignment(assignment);
                logger.log("Assignment submitted by Student " + studentId + " in " + className + ".");
            } else {
                logger.log("Student " + studentId + " not found in " + className + ".");
            }
        } else {
            logger.log("Classroom " + className + " not found.");
        }
    }
}
