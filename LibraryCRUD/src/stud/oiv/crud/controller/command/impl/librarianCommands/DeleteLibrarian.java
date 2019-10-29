package stud.oiv.crud.controller.command.impl.librarianCommands;

import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.LogicException;
import stud.oiv.crud.service.factory.ServiceFactory;

public class DeleteLibrarian implements Command {
    @Override
    public String execute(String request) {
        int id = Integer.parseInt(request);
        try {
            ServiceFactory.getInstance().getLibrarianService().deleteLibrarianById(id);
        }
        catch (LogicException e)
        {
            return "Something go wrong";
        }
        return "done";
    }
}
