package stud.oiv.crud.controller.command.impl.bookCommands;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;
import java.util.Collections;

public class SortBookByDescending implements Command {
    @Override
    public String execute(String request) {
        ArrayList<Book> books = ServiceFactory.getInstance().getLibraryService().getAllBooks();
        Collections.sort(books);
        Collections.reverse(books);
        String result = "";
        for(Book book: books)
        {
            result += book.toString() + '\n';
        }
        return result;
    }
}
