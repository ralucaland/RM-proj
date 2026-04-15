package Teme.Tema8.ex5;

public class MainCourse {

    public static void main(String[] args) {

        OnlineCourse course = new OnlineCourse(
                "QA Automation",
                3,
                "Udemy"
        );

        System.out.println("Curs: " + course.getCourseName());
        System.out.println("Durata: " + course.getDuration() + " luni");
        System.out.println("Platforma: " + course.getPlatform());
    }
}

