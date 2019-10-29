package stud.oiv.crud.controller.command.impl.userCommands;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.User;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.LogicException;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;

public class AddUser implements Command {

    /**
     * <p>Создает пользователя с указанным набором полей</p>
     * @param request поля пользователя через разделитель
     * @return Результат выполнения команды
     */
    @Override
    public String execute(String request) {
        String bookFields[] = request.split("&");
        if(bookFields.length != 4)
            return "Incorrect values";
        User user = new User(bookFields[0],bookFields[1],bookFields[2],bookFields[3],new ArrayList<Book>());
        try {
            ServiceFactory.getInstance().getUserService().addUser(user);
        }
        catch (LogicException e)
        {
            return "Something go wrong";
        }
        return "done";
    }

}
