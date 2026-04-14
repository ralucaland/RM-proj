package Teme.Tema8.Ex1_Book;

public class mainBook {

    public static void main(String[] args) {

        Book book = new Book();

        book.setTitle("Aventurile lui Habarnam");
        book.setAuthor("Nikolai Nosov");

        System.out.println("Titlu: " + book.getTitle());
        System.out.println("Autor: " + book.getAuthor());
    }
}

