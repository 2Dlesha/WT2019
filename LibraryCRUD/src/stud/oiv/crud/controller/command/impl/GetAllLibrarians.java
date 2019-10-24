package stud.oiv.crud.controller.command.impl;

import stud.oiv.crud.beans.Librarian;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;

public class GetAllLibrarians implements Command {
    @Override
    public String execute(String request) {
        ArrayList<Librarian> librarians = ServiceFactory.getInstance().getLibrarianService().getAllLibrarians();
        String result = "";
        for(Librarian librarian: librarians)
        {
            result += librarian.toString() + '\n';
        }
        return result;
    }
}
