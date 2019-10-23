package stud.oiv.crud.view.console;

import stud.oiv.crud.beans.ArtBook;
import stud.oiv.crud.beans.Book;

import java.util.Scanner;

public class ArtBookView implements BookView {
    @Override
    public Book ShowCreateWindow() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter page count:");
        int pageCount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter author:");
        String author = scanner.nextLine();
        System.out.println("Enter genre:");
        String genre = scanner.nextLine();
        return new ArtBook(name,pageCount,author,genre);
    }
}
