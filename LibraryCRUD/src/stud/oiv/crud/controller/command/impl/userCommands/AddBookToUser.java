package stud.oiv.crud.controller.command.impl.userCommands;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.User;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;

public class AddBookToUser implements Command {

    /**
     * <p>Создает пользователя с указанным набором полей</p>
     * @param request поля пользователя через &
     */
    @Override
    public String execute(String request) {
        String params[] = request.split("\\|");
        if(params.length != 2)
            return "Incorrect params";

        int userId = Integer.parseInt(params[0]);
        int bookId = Integer.parseInt(params[1]);

        ServiceFactory.getInstance().getUserService().addBookToUser(userId,bookId);
        return "done";
    }
}
