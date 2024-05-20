import java.util.ArrayList;
import java.util.Scanner;

class MarksheetManager {
    private static ArrayList<Marksheet> marksheets = new ArrayList<>();
    public MarksheetManager() {
    }


    public static void main(String[] args) {
        MarksheetManager manager = new MarksheetManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n");
            System.out.println("*****************************************************************");
            System.out.println("1. Add Marksheet");
            System.out.println("2. View Marksheets");
            System.out.println("3. Delete Marksheet");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Marksheet marksheet = grabStudentDetails(scanner);
                    manager.addMarksheet(marksheet);
                    break;
                case 2:
                    System.out.println("*****************************************************************");
                    System.out.println("Enter roll number to view marksheet: ");
                    int rollToView = scanner.nextInt();
                    manager.viewMarksheet(rollToView);
                    break;

                case 3:
                    System.out.println("*****************************************************************");
                    System.out.println("Enter roll number of the student to delete: ");
                    int rollNumber = scanner.nextInt();
                    manager.deleteMarksheet(rollNumber);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static Marksheet grabStudentDetails(Scanner scanner) {
        Marksheet marksheet = new Marksheet();
        System.out.println("*****************************************************************");
        scanner.nextLine();
        System.out.print("Enter your name: ");
        marksheet.setName(scanner.nextLine().trim().toUpperCase());
        marksheet.setRollNumber(grabIntegerRelatedInfo(scanner, "Roll Number"));
        marksheet.setMathMark(grabIntegerRelatedInfo(scanner, "Marks obtained in Maths"));
        marksheet.setScienceMark(grabIntegerRelatedInfo(scanner, "Marks obtained in Science"));
        marksheet.setSocialMark(grabIntegerRelatedInfo(scanner, "Marks obtained in Social"));
        marksheet.setNepaliMark(grabIntegerRelatedInfo(scanner, "Marks obtained in Nepali"));
        marksheet.setEnglishMark(grabIntegerRelatedInfo(scanner, "Marks obtained in English"));

        return marksheet;
    }

    private static int grabIntegerRelatedInfo(Scanner input, String type) {
        int enteredMark;
        while (true) {
            System.out.print("Please enter " + type + ": ");
            while (!input.hasNextInt()) {
                System.out.println("Character not allowed, please enter an integer number only.");
                input.next();
                System.out.print("Please enter " + type + ": ");
            }
            enteredMark = input.nextInt();

            if (enteredMark < 0 || (enteredMark > 100 && !type.equals("Roll Number"))) {
                System.out.println(type + " cannot be less than 0 and greater than 100");
            } else {
                break;
            }
        }
        return enteredMark;
    }

    public void addMarksheet(Marksheet marksheet) {
        marksheets.add(marksheet);
        System.out.println("Marksheet added successfully!");
    }

    public void viewMarksheet(int rollNumber) {
        Marksheet foundMarksheet = null;
        for (Marksheet marksheet : marksheets) {
            if (marksheet.getRollNumber() == rollNumber) {
                foundMarksheet = marksheet;
                break;
            }
        }

        if (foundMarksheet != null) {
            displayMarkSheet(foundMarksheet);
        } else {
            System.out.println("Marksheet with roll number " + rollNumber + " not found.");
        }
    }



    public void deleteMarksheet(int rollNumber) {
        Marksheet marksheetToRemove = null;
        for (Marksheet marksheet : marksheets) {
            if (marksheet.getRollNumber() == rollNumber) {
                marksheetToRemove = marksheet;
                break;
            }
        }

        if (marksheetToRemove != null) {
            marksheets.remove(marksheetToRemove);
            System.out.println("Marksheet removed successfully!");
        } else {
            System.out.println("Marksheet with roll number " + rollNumber + " not found.");
        }
    }

    private static void displayMarkSheet(Marksheet marksheet) {
        System.out.println("\t\t\tAcademia International College");
        System.out.println("\t\t\t\tGwarko, Lalitpur");
        System.out.println("\t\t\t\t\t9800000000\n");
        System.out.println("Class : X");
        System.out.println("Name : " + marksheet.getName());
        System.out.println("Roll No : " + marksheet.getRollNumber());
        String division = "";
        String status = "";
        double percentage = 0;
        if (marksheet.isAllSubjectPass()) {
            percentage = marksheet.getPercentage();
            status = "PASS";
            if (percentage > 40 && percentage < 60) {
                division = "PASS";
            } else if (percentage > 60 && percentage < 80) {
                division = "FIRST DIVISION";
            } else if (percentage > 80 && percentage <= 100) {
                division = "DISTINCTION";
            }
        }
        System.out.print("---------------------------------------------------|\n");
        System.out.printf("%s\t\t | %s\t\t | %s\t\t | %s\n", "Subject", "FM", "PM", "OM|");
        System.out.print("---------------------------------------------------|\n");
        System.out.printf("%s\t\t | %s\t\t | %s\t\t | %s\n", "Science", "100", "32", marksheet.getScienceMark());
        System.out.print("---------------------------------------------------|\n");
        System.out.printf("%s\t\t | %s\t\t | %s\t\t | %s\n", "Maths", "100", "32", marksheet.getMathMark());
        System.out.print("---------------------------------------------------|\n");
        System.out.printf("%s\t\t | %s\t\t | %s\t\t | %s\n", "Social", "100", "32", marksheet.getSocialMark());
        System.out.print("---------------------------------------------------|\n");
        System.out.printf("%s\t\t | %s\t\t | %s\t\t | %s\n", "Nepali", "100", "32", marksheet.getNepaliMark());
        System.out.print("---------------------------------------------------|\n");
        System.out.printf("%s\t\t | %s\t\t | %s\t\t | %s\n", "English", "100", "32", marksheet.getEnglishMark());
        System.out.print("---------------------------------------------------|\n");
        System.out.println("Result : " + (status.isEmpty() ? "FAIL" : status));
        System.out.println("Division : " + (division.isEmpty() ? "-" : division));
        System.out.println("Percentage : " + (percentage == 0 ? "-" : percentage));
    }
}