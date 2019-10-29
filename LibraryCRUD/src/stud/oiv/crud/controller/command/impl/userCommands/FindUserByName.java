package stud.oiv.crud.controller.command.impl.userCommands;

import stud.oiv.crud.beans.User;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.LogicException;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;

public class FindUserByName implements Command {

    /**
     * <p>Возвращает всех пользователей с указанным именем</p>
     * @param request имя пользователя
     * @return Результат выполнения команды
     */
    @Override
    public String execute(String request) {
        ArrayList<User> allUsers;
        try {
            allUsers = ServiceFactory.getInstance().getUserService().getAllUsers();
        }
        catch (LogicException e)
        {
            return "Something go wrong";
        }
        String result = "";
        for(User user: allUsers)
        {
            if(user.getFirstName().equals(request))
                result += user.toString() + '\n';
        }
        if(result.equals(""))
            return "No user with this name";
        return result;
    }
}
