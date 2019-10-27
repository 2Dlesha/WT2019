package stud.oiv.crud.controller.command.impl.librarianCommands;

import stud.oiv.crud.beans.Librarian;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;

public class SortLibararianByFirstName implements Command {
    @Override
    public String execute(String request) {
        ArrayList<Librarian> librarians = ServiceFactory.getInstance().getLibrarianService().sortByFirstName();
        String result = "";
        for(Librarian librarian: librarians)
        {
            result += librarian.toString() + '\n';
        }
        return result;
    }
}
