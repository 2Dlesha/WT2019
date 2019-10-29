package stud.oiv.crud.controller.command.impl.userCommands;

        import stud.oiv.crud.beans.Book;
        import stud.oiv.crud.beans.User;
        import stud.oiv.crud.controller.command.Command;
        import stud.oiv.crud.service.LogicException;
        import stud.oiv.crud.service.factory.ServiceFactory;

        import java.util.ArrayList;

public class GetAllUsers implements Command {

    /**
     * <p>Возвращает всех пользователей ввиде строки</p>
     * @param request не используется
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
            result += user.toString() + '\n';
        }
        return result;
    }
}
