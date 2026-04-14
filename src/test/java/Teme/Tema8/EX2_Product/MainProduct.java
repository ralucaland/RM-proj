package Teme.Tema8.EX2_Product;

public class MainProduct {

    public static void main(String[] args) {

        Product product = new Product();

        //  Test valid
        product.setName("serviciu consultanta");
        product.setPrice(1000);

        System.out.println("Produs: " + product.getName());
        System.out.println("Pret: " + product.getPrice());

        // Test invalid
        product.setPrice(-1000);

        System.out.println("Pret dupa set invalid: " + product.getPrice());
    }
}