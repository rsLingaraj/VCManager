package CODE;

import java.util.Scanner;

public class VCMapp {
    public static void main(String[] args) {
        ClassroomManager classroomManager = ClassroomManager.getInstance();//to retrieve the singleton instance of ClassroomManager
        Scanner sc = new Scanner(System.in);
        Logger logger = new ConsoleLogger();

        System.out.println("Welcome to the Virtual Classroom Manager!");

        while (true) {
            System.out.println("Enter a command (add_classroom, add_student, schedule_assignment, submit_assignment, or exit):");
            String input = sc.nextLine();
            String[] token = input.split(" ");

            try {
                switch (token[0]) {
                    case "add_classroom":
                        classroomManager.addClassroom(token[1]);
                        break;
                    case "add_student":
                        classroomManager.addStudent(token[1], token[2]);
                        break;
                    case "schedule_assignment":
                        classroomManager.scheduleAssignment(token[1], token[2]);
                        break;
                    case "submit_assignment":
                        classroomManager.submitAssignment(token[1], token[2], token[3]);
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
