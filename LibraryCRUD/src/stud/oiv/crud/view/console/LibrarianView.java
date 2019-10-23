package stud.oiv.crud.view.console;

import stud.oiv.crud.beans.Librarian;
import java.util.Scanner;

public class LibrarianView {
    public static Librarian ShowCreateWindow()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();
        return new Librarian(firstName,lastName,phoneNumber);
    }
}
