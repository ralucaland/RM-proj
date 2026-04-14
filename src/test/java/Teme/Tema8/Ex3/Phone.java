package Teme.Tema8.Ex3;

public class Phone extends Device {

    @Override
    public void powerOn() {
        System.out.println("Telefonul se aprinde");
    }
    public void call() {
        System.out.println("Se efectueaza un apel");
    }
}