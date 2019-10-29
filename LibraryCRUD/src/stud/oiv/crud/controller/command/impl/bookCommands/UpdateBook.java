package stud.oiv.crud.controller.command.impl.bookCommands;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.factory.BookFactory;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.LogicException;
import stud.oiv.crud.service.factory.ServiceFactory;

public class UpdateBook implements Command {
    @Override
    public String execute(String request) {
        String params[] = request.split("\\|");
        Book book = BookFactory.createBook(params[1],params[2]);
        try {
            ServiceFactory.getInstance().getLibraryService().update(Integer.parseInt(params[0]),book);
        }
        catch (LogicException e)
        {
            return "Something go wrong";
        }
        return "done";
        //ServiceFactory.getInstance().getLibraryService().update(bookId,book);
    }
}
