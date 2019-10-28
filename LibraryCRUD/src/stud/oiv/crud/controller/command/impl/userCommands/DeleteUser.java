package stud.oiv.crud.controller.command.impl.userCommands;

import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.factory.ServiceFactory;

public class DeleteUser implements Command {

    /**
     * <p>Удаляет заданного пользователя</p>
     * @param request id пользователя
     */
    @Override
    public String execute(String request) {
        int bookId = Integer.parseInt(request);
        ServiceFactory.getInstance().getUserService().deleteUserById(bookId);
        return "done";
    }
}
