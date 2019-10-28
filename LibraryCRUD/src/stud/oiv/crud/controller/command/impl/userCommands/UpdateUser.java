package stud.oiv.crud.controller.command.impl.userCommands;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.User;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;

public class UpdateUser implements Command {


    /**
     * <p>Выполняет обновление информации о пользователе</p>
     * @param request id пользователя и поля ввиде строк через & (id|user fields)
     */
    @Override
    public String execute(String request) {
        String params[] = request.split("\\|");
        String userFields[] = params[1].split("&");
        if(userFields.length != 4)
            return "Incorrect values";
        User user = new User(userFields[0],userFields[1],userFields[2],userFields[2],new ArrayList<Book>());
        ServiceFactory.getInstance().getUserService().updateUser(Integer.parseInt(params[0]),user);
        return "done";
    }
}
