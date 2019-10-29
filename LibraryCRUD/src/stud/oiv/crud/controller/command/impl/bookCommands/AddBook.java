package stud.oiv.crud.controller.command.impl.bookCommands;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.factory.BookFactory;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.LogicException;
import stud.oiv.crud.service.factory.ServiceFactory;

public class AddBook implements Command {
    @Override
    public String execute(String request) {
        String delimener = "\\|";
        String params[] = request.split(delimener);
        Book book = BookFactory.createBook(params[0],params[1]);
        String result = "done";
        try {
            ServiceFactory.getInstance().getLibraryService().addBook(book);
        }
        catch (LogicException e)
        {
            result =  "Something go wrong";
        }
        return result;
    }
}
