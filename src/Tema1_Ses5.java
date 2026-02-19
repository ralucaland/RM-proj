public class Tema1_Ses5 {
    /*
    a.Creează variabile pentru: varsta unui student, inaltimea acestuia, daca este prezent la curs. Afiseaza datele prin mesaje/propozitii.
    Crează doua variabile int si una double. Calculeaza suma celor doua valori int. Calculeaza media dintre toate 3.
    Creaza o variabila pentru varsta. Dacă persoana are 18 sau mai mult, afișează: “Acces permis”, altfel “Acces interzis”.
    Calculeaza suma numerelor de la 20 la 50.
    Afișează numerele de la 10 la 1 folosind while.
    Creează o metodă care afișează: “Invat Java!”
    Creaza o metoda cu 2 parametrii int, care returneaza produsul celor doi parametrii.
    h.Calculează suma numerelor pare de la 1 la 50. Crează o metoda care returneaza rezultatul.
    Creaza o metoda cu 3 parametrii. Returneaza media celor trei parametrii.
    Creeaza o metoda care primeste 2 parametrii: start si end. Afiseaza toate numerele cuprinse intre aceste doua numere
*/
    public static void main(String[] args) {
        System.out.println("H.1 Suma");
        CALCULATOR_par(1,50);
        System.out.println("H.2 Produsul");
    }

    public static void CALCULATOR_par(int x, int y) {
        int suma=0;

        for (int contor = x; contor <= y; contor++) {
            if(contor % 2==0) {

                System.out.print(contor);
                if(contor<y) {
                    System.out.print(",");
                }
                System.out.println(suma);
                suma = suma+contor;
            }
        }
        System.out.println("\n"+suma);
    }
}
