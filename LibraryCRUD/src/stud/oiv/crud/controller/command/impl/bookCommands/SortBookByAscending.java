package stud.oiv.crud.controller.command.impl.bookCommands;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.LogicException;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;
import java.util.Collections;

public class SortBookByAscending implements Command {
    @Override
    public String execute(String request) {
        ArrayList<Book> books;
        try {
            books = ServiceFactory.getInstance().getLibraryService().getAllBooks();
        }
        catch (LogicException e)
        {
            return "Something go wrong";
        }
        Collections.sort(books);
        String result = "";
        for(Book book: books)
        {
            result += book.toString() + '\n';
        }
        return result;
    }
}
