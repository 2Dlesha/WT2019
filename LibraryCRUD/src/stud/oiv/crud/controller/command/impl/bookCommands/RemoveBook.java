package stud.oiv.crud.controller.command.impl.bookCommands;

import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.factory.ServiceFactory;

public class RemoveBook implements Command {
    @Override
    public String execute(String request) {
        int bookId = Integer.parseInt(request);
        ServiceFactory.getInstance().getLibraryService().deleteBookById(bookId);
        return "done";
    }
}
