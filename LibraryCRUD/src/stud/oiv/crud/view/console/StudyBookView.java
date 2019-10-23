package stud.oiv.crud.view.console;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.StudyBook;

import java.util.Scanner;

public class StudyBookView implements BookView {
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
        System.out.println("Enter subject:");
        String subject = scanner.nextLine();
        return new StudyBook(name,pageCount,author,subject);
    }
}
