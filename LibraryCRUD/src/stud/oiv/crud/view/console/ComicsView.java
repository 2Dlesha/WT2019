package stud.oiv.crud.view.console;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.Comics;

import java.util.Scanner;

public class ComicsView implements BookView {
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
        System.out.println("Enter type:");
        String type = scanner.nextLine();
        return new Comics(name,pageCount,author,genre,type);
    }
}
