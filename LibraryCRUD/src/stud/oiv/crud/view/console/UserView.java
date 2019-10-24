package stud.oiv.crud.view.console;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserView {
    public static User ShowCreateWindow()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter date of membership:");
        String date = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        return new User(firstName,lastName,date,address,new ArrayList<Book>());
    }

    public static void ShowInfoWindow(User user)
    {
        System.out.print("Id: ");
        System.out.print(user.getId());
        System.out.print("First name: ");
        System.out.print(user.getFirstName());
        System.out.println("Last name:");
        System.out.print(user.getLastName());
        System.out.println("Date of membership:");
        System.out.print(user.getDateOfMembership());
        System.out.println("Address:");
        System.out.print(user.getAddress());
    }

    void ShowList(ArrayList<User> users){
        System.out.println("----------------------------------------------------------");
        for (User user:users) {
            System.out.println(user.toString());
        }
        System.out.println("----------------------------------------------------------");
    }
}
