public class Tema1_Ses5 {
    /*
    a.Creează variabile pentru: varsta unui student, inaltimea acestuia, daca este prezent la curs. Afiseaza datele prin mesaje/propozitii.
    b. Crează doua variabile int si una double. Calculeaza suma celor doua valori int. Calculeaza media dintre toate 3.
    c. Creaza o variabila pentru varsta. Dacă persoana are 18 sau mai mult, afișează: “Acces permis”, altfel “Acces interzis”.
    d. Calculeaza suma numerelor de la 20 la 50.
    e. Afișează numerele de la 10 la 1 folosind while.
    f. Creează o metodă care afișează: “Invat Java!”
    g. Creaza o metoda cu 2 parametrii int, care returneaza produsul celor doi parametrii.
    h.Calculează suma numerelor pare de la 1 la 50. Crează o metoda care returneaza rezultatul.
    i.Creaza o metoda cu 3 parametrii. Returneaza media celor trei parametrii.
    j.Creeaza o metoda care primeste 2 parametrii: start si end. Afiseaza toate numerele cuprinse intre aceste doua numere
*/
    //functia 2A: RETURNEAZA mesajul DE TIP STRING " Daca astazi este Luni ,Marti sau Miercuri, sudentul este prezent. El are 20 de ani si 1.75m"
    public static void main(String[] args) {
        int varsta = 20;
        double inaltime = 1.75;
        boolean prezenta = false;
        int zSaptamana= 4; // ex. 6=sambata, 1=luni

        int x = 6; int y =10; double z = 15.;
        int suma= x+y;
        double medie = (suma+ z)/3;


       String tipAcces="";
       if(varsta>18){
           tipAcces= "Acces permis";
        }else{
           tipAcces= "Acces interzis";
       }

       int sumaD = 0;
       for(int contor= 20; contor<=50; contor++){
       sumaD= contor+sumaD ;
       }




        System.out.println("1A.Prezenta Cursuri");
        //PrezentaCursuri(varsta,inaltime, prezenta);
        //PrezentaCursuri(varsta, inaltime,true);
        //PrezentaCursuri(30,1.61, false);
        System.out.println("1B.Orar Cursuri:");
        System.out.println(Orar(varsta,inaltime, zSaptamana));

        System.out.print("1B:");
        System.out.println(medie);
        System.out.print("1C:");
        System.out.println(tipAcces);
        System.out.print("1D:");
        System.out.println(sumaD);
        System.out.print("1E:");
        int r=10;
        while(r>=1){
            System.out.println(r);
            r--;
        }
        System.out.print("1F:");
        Invat();

        System.out.print("1G:");
        System.out.println(inmultire( 18, 17));


        //System.out.println("1H. Suma");
        //CALCULATOR_par(1,50);

        System.out.print("1I:");
        System.out.println(mediaI( 6, 41,36));

        System.out.print("1J:");
        startEnd(100, 109);


    }
    //functia 1A: AFISEAZA mesajul " Studentul de 20 de ani si 1,75 m este prezent la curs"-->
    //CONTINE PARAMETRII: int-varsta, double-inaltime, boolean-Prezenta

    public static void PrezentaCursuri(int _varsta,double _inaltime, boolean _prezenta){
        System.out.print("Studentul are " + _varsta + " de ani si " + _inaltime + " m si ");
        if(_prezenta == true){
            System.out.println("este prezent la curs.");
        }else{
            System.out.println("este absent la curs.");
        }
    }
    //functia 2A: RETURNEAZA mesajul DE TIP STRING " Daca astazi este Luni ,Marti sau Miercuri, sudentul este prezent. El are 20 de ani si 1.75m"

    public static String Orar( int varsta, double inaltime,int zSaptamana ){
        String NumeZi = "";
        String estePrezent = "";
        if(zSaptamana== 1){
            NumeZi = "Luni";
        } else if (zSaptamana==2){
            NumeZi = "Marti";
        }else if (zSaptamana==3){
            NumeZi = "Miercuri";
        }else if (zSaptamana==4){
            NumeZi = "Joi";
        }else if (zSaptamana==5){
            NumeZi = "Vineri";
        }else if (zSaptamana==6){
            NumeZi = "Sambata";
        }else if (zSaptamana==7){
            NumeZi = "Duminica";
        } else {
            NumeZi = "Sarbatoare";
        }

        if((zSaptamana==1||zSaptamana==2||zSaptamana==3 )){
            estePrezent = "prezent";
        }else{
            estePrezent= "absent";
        }

        return "Daca astazi este " + NumeZi + " ,studentul este " + estePrezent +". El are "+ varsta+ " ani si "+ inaltime+" m";

    }

    public static void Invat(){
        System.out.println("Invat Java!");
    }
    public static int inmultire( int g, int h){
        return g*h;
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

    public static int mediaI( int g, int h,int j){
        return (g+h+j)/3;
    }

    public static void startEnd(int start,int end){
        for(int contor = start; contor<=end; contor++){
            System.out.println(contor);
        }
    }

}
