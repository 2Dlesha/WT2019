package stud.oiv.crud.controller.command.impl.librarianCommands;

import stud.oiv.crud.beans.Librarian;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.LogicException;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;

public class UpdateLibrarian implements Command {

    @Override
    public String execute(String request) {
        String params[] = request.split("\\|");
        String librarianFields[] = params[1].split("&");
        if(librarianFields.length != 3)
            return "Incorrect values";
        Librarian librarian = new Librarian(librarianFields[0],librarianFields[1],librarianFields[2]);
        try {
            ServiceFactory.getInstance().getLibrarianService().updateLibrarian(Integer.parseInt(params[0]),librarian);
        }
        catch (LogicException e)
        {
            return "Something go wrong";
        }
        return "done";
    }
}
