package stud.oiv.crud.controller.command.impl.userCommands;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.User;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.LogicException;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;

public class RemoveBookFromUser implements Command {
    /**
     * <p>Выполняет удаление книги из книг пользователя</p>
     * @param request id пользователя|id книги
     * @return Результат выполнения команды
     */
    @Override
    public String execute(String request) {
        String params[] = request.split("\\|");
        if(params.length != 2)
            return "Incorrect params";

        int userId = Integer.parseInt(params[0]);
        int bookId = Integer.parseInt(params[1]);

        try {
            ServiceFactory.getInstance().getUserService().deleteBookFromUser(userId,bookId);
        }
        catch (LogicException e)
        {
            return "Something go wrong";
        }
        return "done";
    }
}
