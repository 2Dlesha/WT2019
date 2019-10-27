package stud.oiv.crud.controller.command.impl.librarianCommands;

import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.factory.ServiceFactory;

public class DeleteLibrarian implements Command {
    @Override
    public String execute(String request) {
        int id = Integer.parseInt(request);
        ServiceFactory.getInstance().getLibrarianService().deleteLibrarianById(id);
        return "done";
    }
}
