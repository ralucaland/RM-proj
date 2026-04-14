package Teme.Tema8.Ex4;
import Teme.Tema8.Ex4.numeClasa;

public class MainAccount{

    public static void main(String[] args) {

        numeClasa admin = new numeClasa();

        admin.setUsername("admin123");

        admin.login();       // metoda mostenita
        admin.deleteUser();  // metoda proprie
    }
}