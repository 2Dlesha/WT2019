package stud.oiv.crud.dao.factory;

import stud.oiv.crud.dao.BookDAO;
import stud.oiv.crud.dao.impl.FileBookDAO;
import stud.oiv.crud.dao.impl.FileLibrarianDAO;
import stud.oiv.crud.dao.impl.FileUserDAO;
import stud.oiv.crud.dao.LibrarianDAO;
import stud.oiv.crud.dao.UserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final BookDAO fileBookDAO = new FileBookDAO();
    private final UserDAO fileUserDAO = new FileUserDAO();
    private final LibrarianDAO fileLibrarianDAO = new FileLibrarianDAO();

    public static DAOFactory getInstance()
    {
        return instance;
    }

    public BookDAO getBookDAO()
    {
        return fileBookDAO;
    }
    public UserDAO getUserDAO()
    {
        return fileUserDAO;
    }
    public  LibrarianDAO getLibrarianDAO()
    {
        return fileLibrarianDAO;
    }

}
