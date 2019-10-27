package stud.oiv.crud.controller.command.impl.librarianCommands;

import stud.oiv.crud.beans.Librarian;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;

public class FindLibrarianByName implements Command {
    @Override
    public String execute(String request) {
        ArrayList<Librarian> librarians = ServiceFactory.getInstance().getLibrarianService().getAllLibrarians();
        String result = "";
        for(Librarian librarian: librarians)
        {
            if(librarian.getFirstName().equals(request))
                result += librarian.toString() + '\n';
        }
        if(result.equals(""))
            return "No books with this name";
        return result;
    }
}
