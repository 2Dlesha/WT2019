package stud.oiv.crud.view.console;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;

public interface BookView {
    String ShowCreateWindow();
    default void ShowList(ArrayList<Book> books){
        System.out.println("----------------------------------------------------------");
        for (Book book: books ) {
            System.out.println(book.toString());
        }
        System.out.println("----------------------------------------------------------");
    }
}
