package CODE;

import java.util.Scanner;

public class VCMapp {
    public static void main(String[] args) {
        ClassroomManager classroomManager = ClassroomManager.getInstance();
        Scanner scanner = new Scanner(System.in);
        Logger logger = new ConsoleLogger();

        System.out.println("Welcome to the Virtual Classroom Manager!");

        while (true) {
            System.out.println("Enter a command (add_classroom, add_student, schedule_assignment, submit_assignment, or exit):");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            try {
                switch (tokens[0]) {
                    case "add_classroom":
                        classroomManager.addClassroom(tokens[1]);
                        break;
                    case "add_student":
                        classroomManager.addStudent(tokens[1], tokens[2]);
                        break;
                    case "schedule_assignment":
                        classroomManager.scheduleAssignment(tokens[1], tokens[2]);
                        break;
                    case "submit_assignment":
                        classroomManager.submitAssignment(tokens[1], tokens[2], tokens[3]);
                        break;
                    case "exit":
                        logger.log("Exiting the application.");
                        return;
                    default:
                        logger.log("Invalid command.");
                }
            } catch (Exception e) {
                logger.log("Error: " + e.getMessage());
            }
        }
    }
}
