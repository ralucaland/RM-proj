package Teme.Tema8.ex5;

public class OnlineCourse extends Course {

    private String platform;

    // Constructor
    public OnlineCourse(String courseName, int duration, String platform) {
        super(courseName, duration); // trimite date către Course
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }
}