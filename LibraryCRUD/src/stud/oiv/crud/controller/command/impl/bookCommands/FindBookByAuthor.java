package stud.oiv.crud.controller.command.impl.bookCommands;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.LogicException;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;

public class FindBookByAuthor implements Command {
    @Override
    public String execute(String request) {
        ArrayList<Book> books;
        String result = "";
        try {
            books = ServiceFactory.getInstance().getLibraryService().getAllBooks();
        }
        catch (LogicException e)
        {
            return "Something go wrong";
        }
        for(Book book: books)
        {
            if(book.getAuthor().equals(request))
                result += book.toString() + '\n';
        }
        if(result.equals(""))
            return "No books with this author";
        return result;
    }
}
