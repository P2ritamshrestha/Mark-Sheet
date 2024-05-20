Marksheet Project
Purpose: 
  The Marksheet Project efficiently manages and displays student mark sheets.
Functionality:
  Stores student details and corresponding marks.
  Utilizes ArrayLists for flexible organization of information.
  Allows easy access to mark sheets by roll number.
Target Users:
  Educators
  Anyone involved in managing student records
Advantages:
  Simplifies the process of accessing specific student data.
  Ensures platform independence and easy integration with existing systems.


MarkSheet Format:
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

Contact:
if you have any questions or feedback.
E-mail : p2ritamsthagrk@gmail.com
Instagram id : p1ritam
