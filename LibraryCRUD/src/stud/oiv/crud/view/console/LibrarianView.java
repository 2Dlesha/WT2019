package stud.oiv.crud.view.console;

import stud.oiv.crud.beans.Librarian;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;
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

    void ShowList(ArrayList<Librarian> librarians){
        System.out.println("----------------------------------------------------------");
        for (Librarian librarian:librarians) {
            System.out.println(librarian.toString());
        }
        System.out.println("----------------------------------------------------------");
    }
}
