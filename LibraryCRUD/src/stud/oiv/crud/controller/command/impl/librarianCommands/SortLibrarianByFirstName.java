package stud.oiv.crud.controller.command.impl.librarianCommands;

import stud.oiv.crud.beans.Librarian;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.LogicException;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;

public class SortLibrarianByFirstName implements Command {

    @Override
    public String execute(String request) {
        ArrayList<Librarian> librarians;// = ServiceFactory.getInstance().getLibrarianService().getAllLibrarians();
        try {
            librarians = ServiceFactory.getInstance().getLibrarianService().getAllLibrarians();
        }
        catch (LogicException e)
        {
            return "Something go wrong";
        }
        String result = "";
        for(Librarian librarian: librarians)
        {
            result += librarian.toString() + '\n';
        }
        return result;
    }
}
