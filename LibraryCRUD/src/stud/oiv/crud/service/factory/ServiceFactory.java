package stud.oiv.crud.service.factory;

import stud.oiv.crud.service.impl.LibrarianServiceImpl;
import stud.oiv.crud.service.impl.LibraryServiceImpl;
import stud.oiv.crud.service.impl.UserServiceImpl;
import stud.oiv.crud.service.LibrarianService;
import stud.oiv.crud.service.LibraryService;
import stud.oiv.crud.service.UserService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final LibrarianService librarianService = new LibrarianServiceImpl();
    private final LibraryService libraryService = new LibraryServiceImpl();
    private final UserService userService = new UserServiceImpl();

    public static ServiceFactory getInstance()
    {
        return  instance;
    }

    public LibraryService getLibraryService()
    {
        return libraryService;
    }

    public LibrarianService getLibrarianService()
    {
        return  librarianService;
    }

    public UserService getUserService()
    {
        return userService;
    }
}
