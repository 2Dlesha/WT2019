package stud.oiv.crud.controller.command.impl.librarianCommands;

import stud.oiv.crud.beans.Librarian;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.LogicException;
import stud.oiv.crud.service.factory.ServiceFactory;

public class AddLibrarian implements Command {
    @Override
    public String execute(String request) {
        String bookFields[] = request.split("&");
        if(bookFields.length != 3)
            return "Incorrect values";
        Librarian librarian = new Librarian(bookFields[0],bookFields[1],bookFields[2]);
        try {
            ServiceFactory.getInstance().getLibrarianService().addLibrarian(librarian);
        }
        catch (LogicException e)
        {
            return "Something go wrong";
        }
        return "done";
    }
}
