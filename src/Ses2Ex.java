public class Ses2Ex {
    public static void main(String[]args){
        // Exercitiu 1
        System.out.println("Exercitiu 1");

        System.out.println("Raluca M");
        System.out.println("2/2");
        System.out.println(1+2);
        // Exercitiu 2
        System.out.println("\nExercitiu 2");
        String Nume = "Ral";
        int Varsta = 2;
        String NumeFamilie ="Benciu";
        int NrMembriFam = 4;
        boolean animaldc= true;
        int NrAnim = 2;
        boolean singurLaParinti = false;
        System.out.println(Nume +" "+NumeFamilie+ " are "+ Varsta +" ani si in familia ei sunt "+ NrMembriFam +" membri "+ NrAnim + " pisici");

        System.out.println("\nExercitiu 3");
        int varstaPesteCinciAni= Varsta+5;
        int NrMembriFam_Total= NrMembriFam+NrAnim;
        System.out.println(varstaPesteCinciAni);
        System.out.println("Exercitiu 3b");
        System.out.println(NrMembriFam_Total);

        System.out.println("\nExercitiu 4");
        System.out.println("Ma numesc "+Nume+ " , am "+Varsta+" ani, si am "+ NrAnim +" animale de companie"  );

        System.out.println("\nExercitiu 5");
        int a=10; int b=11;
        if (a%2==0){
            System.out.println (a+ " este numar par");
        }
        else {
            System.out.println (a+ " este numar impar");
        }
        System.out.println("\nExercitiu 5b");
        if (a<b){
            System.out.println (b+ " este mai mare ca "+ a);
        }
        else {
            System.out.println(a + " este mai mare ca " + b);
        }
        System.out.println("\nExercitiu 5c");
        boolean ver = (b>=9) && (b<=10);
        System.out.println(ver);

    }
}