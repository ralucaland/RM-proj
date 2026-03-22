public class Ses1 {

    public static void main(String[] args) {
        int age = 25;
        String name = "Anamaria";
        boolean isStudent = true;
        System.out.println("Exercitiul 1");
        if (age > 18) {
            System.out.println("Studentul este major");
        } else {
            System.out.println("Studentul este minor");
        }
        System.out.println("\nExercitiul 1b");
        Ses1.example1();
        System.out.println("\n\nExercitiul 3");
        Ses1.example2(25,20 );
        System.out.println("\nExercitiul 3b");
        Ses1.example3( 30, 35);
        System.out.println("\nExercitiul 4  ");
        Ses1.example4( 30, 35);
    }

    public static void example1() {
        for (int i = 0; i <= 10; i++) {
            // 0,1,2,3,4,5,6,7,8,9,10
            System.out.print(i);
            if(i<10){
                System.out.print(",");
            }
        }

    }
    public static void example2(int x, int i) {
        while (i < x) {
            //20,21,22,23,24,
            System.out.print(i);
            i++;
            if(i<=24){
                System.out.print(",");
            }
        }
        System.out.println("\nExercitiul 3c");
        //apelat din fuctia2 la functia exemple3
        //executa functia do while pana cand ajunge la conditie. contia i este > decat x,
        // drept urmare printeaz prima data
        example3(10,20);
    }
    public static void example3(int x, int i){
            do {
                System.out.println("Iteratie:" + i);
            } while (i < x);
        }


        // Exrcitiul 4 nu ruleaza- fiind un while intai evalueaza conditia.
        // Conditia nu este indeplinita--> nu ruleaza
    public static void example4(int x, int i){
        System.out.println("Este i - " + i + " mai mic ca x - " + x  + ": (i<x) =>" + (i<x));
        while (i < x) {
            System.out.println("Iteratie:" + i);

        }
    }
}
