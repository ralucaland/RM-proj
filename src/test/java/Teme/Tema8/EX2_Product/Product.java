package Teme.Tema8.EX2_Product;

public class Product {

    private String name;
    private double price;

    // Getter name
    public String getName() {
        return name;
    }

    // Setter name
    public void setName(String name) {
        this.name = name;
    }

    // Getter price
    public double getPrice() {
        return price;
    }

    // Setter price cu VALIDARE
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Pret invalid! Trebuie sa fie > 0");
        }
    }
}