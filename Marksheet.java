import java.util.Scanner;

public class Marksheet {
    private String name;
    private int rollNumber;
    private int scienceMark;
    private int mathMark;
    private int socialMark;
    private int nepaliMark;
    private int englishMark;

    public Marksheet(String name, int rollNumber, int scienceMark, int mathMark, int socialMark, int nepaliMark, int englishMark) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.scienceMark = scienceMark;
        this.mathMark = mathMark;
        this.socialMark = socialMark;
        this.nepaliMark = nepaliMark;
        this.englishMark = englishMark;
    }

    public Marksheet() {

    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public int getScienceMark() {
        return scienceMark;
    }

    public int getMathMark() {
        return mathMark;
    }

    public int getSocialMark() {
        return socialMark;
    }

    public int getNepaliMark() {
        return nepaliMark;
    }

    public int getEnglishMark() {
        return englishMark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setScienceMark(int scienceMark) {
        this.scienceMark = scienceMark;
    }

    public void setMathMark(int mathMark) {
        this.mathMark = mathMark;
    }

    public void setSocialMark(int socialMark) {
        this.socialMark = socialMark;
    }

    public void setNepaliMark(int nepaliMark) {
        this.nepaliMark = nepaliMark;
    }

    public void setEnglishMark(int englishMark) {
        this.englishMark = englishMark;
    }

    public boolean isAllSubjectPass() {
        return scienceMark >= 32 && mathMark >= 32 && socialMark >= 32 && nepaliMark >= 32 && englishMark >= 32;
    }

    public double getPercentage() {
        int totalMarks = scienceMark + mathMark + socialMark + nepaliMark + englishMark;
        return (totalMarks / 5.0);
    }

}
