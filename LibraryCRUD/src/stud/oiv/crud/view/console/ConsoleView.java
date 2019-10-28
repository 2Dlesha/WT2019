package stud.oiv.crud.view.console;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.Librarian;
import stud.oiv.crud.beans.User;
import stud.oiv.crud.beans.factory.BookFactory;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.controller.command.impl.bookCommands.*;
import stud.oiv.crud.controller.command.impl.librarianCommands.*;
import stud.oiv.crud.controller.command.impl.userCommands.*;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.Scanner;

public class ConsoleView {

    public void Show() {
        boolean exitFlag = false;
        Scanner scanner = new Scanner(System.in);

        while (!exitFlag) {
            System.out.println("What are you want to do?");
            System.out.println("1. See book list");
            System.out.println("2. See member list");
            System.out.println("3. See librarian list");
            System.out.println("4. Exit");

            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "1": {
                    ShowBooks();
                    break;
                }
                case "2": {
                    ShowMembers();
                    break;
                }
                case "3": {
                    ShowLibrarians();
                    break;
                }
                case "4": {
                    exitFlag = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect value!");
                }
            }
        }

    }

    public void ShowBooks(){
        boolean endOfAction = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Book List");
        for (Book book: ServiceFactory.getInstance().getLibraryService().getAllBooks() ) {
            System.out.println(book.toString());
        }


        while (!endOfAction) {

            System.out.println("What are you want to do?");
            System.out.println("1. Edit book");
            System.out.println("2. Delete book");
            System.out.println("3. Create book");
            System.out.println("4. Sort by ascending");
            System.out.println("5. Sort by descending");
            System.out.println("6. Find book by name");
            System.out.println("7. Find book by author");
            System.out.println("8. Exit");


            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "1": {
                    System.out.println("Enter book type: ");
                    String bookType = scanner.nextLine();
                    System.out.println("Enter book id: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    BookView bookView = BookViewFactory.GetView(bookType);
                    if(bookView == null)
                    {
                        System.out.println("Incorrect book type");
                        continue;
                    }

                    String bookFields = bookView.ShowCreateWindow();
                    Command command = new UpdateBook();
                    command.execute(String.join("|",Integer.toString(bookId),bookType,bookFields));
                    break;
                }
                case "2": {
                    System.out.println("Enter book id: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    Command command = new RemoveBook();
                    command.execute(Integer.toString(bookId));
                    break;
                }
                case "3": {
                    System.out.println("Enter book type: ");
                    String bookType = scanner.nextLine();
                    BookView bookView = BookViewFactory.GetView(bookType);
                    if(bookView == null)
                    {
                        System.out.println("Incorrect book type");
                        continue;
                    }

                    String bookFields = bookView.ShowCreateWindow();
                    AddBook command = new AddBook();
                    command.execute(String.join("|",bookType,bookFields));
                    break;
                }
                case "4": {
                    Command command = new SortBookByAscending();
                    System.out.println(command.execute(null));
                    break;

                }
                case "5": {
                    Command command = new SortBookByDescending();
                    System.out.println(command.execute(null));
                    break;
                }
                case "6": {
                    System.out.println("Enter book name: ");
                    String bookName = scanner.nextLine();
                    Command command = new FindBookByName();
                    System.out.println(command.execute(bookName ));
                    break;
                }
                case "7": {
                    System.out.println("Enter author name: ");
                    String authorName = scanner.nextLine();
                    Command command = new FindBookByAuthor();
                    System.out.println(command.execute(authorName));
                    break;
                }
                case "8":
                    {
                        endOfAction = true;
                        break;
                    }
                default: {
                    System.out.println("Incorrect value!");
                }
            }
        }
    }

    public void ShowMembers(){
        boolean endOfAction = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("User List");
        for (User user1: ServiceFactory.getInstance().getUserService().getAllUsers() )
            System.out.println(user1.toString());

        while (!endOfAction) {
            System.out.println("What are you want to do?");
            System.out.println("1. Edit User");
            System.out.println("2. Delete User");
            System.out.println("3. Create User");
            System.out.println("4. Add book to user");     ////////////////TODO
            System.out.println("5. Delete book from user");////////////////TODO
            System.out.println("6. Sort by ascending");
            System.out.println("7. Sort by descending");
            System.out.println("8. Find user by name");
            System.out.println("9. Show user book");
            System.out.println("10. Exit");


            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "1": {
                    System.out.println("Enter user id: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    String userFields = UserView.ShowCreateWindow();
                    Command command = new UpdateUser();
                    command.execute(String.join("|",Integer.toString(userId),userFields));
                    break;
                }
                case "2": {
                    System.out.println("Enter user id: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    Command command = new DeleteUser();
                    command.execute(Integer.toString(userId));
                    break;
                }
                case "3": {
                    String userFields = UserView.ShowCreateWindow();
                    Command command = new AddUser();
                    command.execute(userFields);
                    break;
                }
                case "4": {
                    System.out.println("Enter user id: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter book id: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    Command command = new AddBookToUser();
                    command.execute(String.join("|",Integer.toString(userId),Integer.toString(bookId)));
                    break;
                }
                case "5": {
                    System.out.println("Enter user id: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter book id: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    Command command = new RemoveBookFromUser();
                    command.execute(String.join("|",Integer.toString(userId),Integer.toString(bookId)));
                    break;
                }
                case "6": {
                    Command command = new SortUsersByAscending();
                    System.out.println(command.execute(null));
                    break;
                }
                case "7": {
                    Command command = new SortUsersByDescending();
                    System.out.println(command.execute(null));
                    break;
                }
                case "8": {
                    System.out.println("Enter user name: ");
                    String userName = scanner.nextLine();
                    Command command = new FindUserByName();
                    System.out.println(command.execute(userName));
                    break;
                }
                case "9":
                {
                    System.out.println("Enter user id: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    Command command = new GetUserBook();
                    System.out.println(command.execute(Integer.toString(userId)));
                    break;
                }
                case "10":
                {
                    endOfAction = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect value!");
                }
            }
        }
    }

    public void ShowLibrarians(){
        boolean endOfAction = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Librarian List");
        var r = new GetAllLibrarians();
        System.out.println(r.execute(null));

        while (!endOfAction) {
            System.out.println("What are you want to do?");
            System.out.println("1. Edit Librarian");
            System.out.println("2. Delete Librarian");
            System.out.println("3. Create Librarian");
            System.out.println("4. Sort by ascending");
            System.out.println("5. Sort by descending");
            System.out.println("6. Find librarian by name");
            System.out.println("6. Find librarian by name");
            System.out.println("7. Exit");

            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "1": {
                    System.out.println("Enter librarian id: ");
                    int librarianId = scanner.nextInt();
                    scanner.nextLine();
                    String librarianFields = LibrarianView.ShowCreateWindow();
                    Command command = new UpdateLibrarian();
                    command.execute(String.join("|",Integer.toString(librarianId),librarianFields));
                    break;
                }
                case "2": {
                    System.out.println("Enter book id: ");
                    int librarianId = scanner.nextInt();
                    Command command = new DeleteLibrarian();
                    command.execute(Integer.toString(librarianId));
                    break;
                }
                case "3": {
                    String librarianFields = LibrarianView.ShowCreateWindow();
                    Command command = new AddLibrarian();
                    command.execute(librarianFields);
                    break;
                }
                case "4": {
                    Command command = new SortLibrarianByAscending();
                    System.out.println(command.execute(null));
                    break;
                }
                case "5": {
                    Command command = new SortLibrarianByDescending();
                    System.out.println(command.execute(null));
                    break;
                }
                case "6": {
                    System.out.println("Enter librarian name: ");
                    String librarianName = scanner.nextLine();
                    Command command = new FindLibrarianByName();
                    System.out.println(command.execute(librarianName));
                    break;
                }
                case "7":
                {
                    endOfAction = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect value!");
                }
            }
        }
    }



}
