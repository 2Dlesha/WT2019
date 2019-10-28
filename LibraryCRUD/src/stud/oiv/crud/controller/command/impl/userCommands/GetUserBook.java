package stud.oiv.crud.controller.command.impl.userCommands;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;

public class GetUserBook implements Command {

    /**
     * <p>Получает все книги пользователя</p>
     * @param request id пользователя
     */
    @Override
    public String execute(String request) {
        String result = "";
        try {
            Integer id = Integer.parseInt(request);
            ArrayList<Book> books = ServiceFactory.getInstance().getUserService().getUserBooks(id);
            for (Book book: books)
            {
                result += book.toString() + '\n';
            }
        }
        catch (Exception e)
        {
            result = "Incorrect params";
        }
        return result;
    }
}
