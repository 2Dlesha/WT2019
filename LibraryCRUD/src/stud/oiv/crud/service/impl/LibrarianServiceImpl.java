package stud.oiv.crud.service.impl;

import stud.oiv.crud.beans.Librarian;
import stud.oiv.crud.dao.DAOException;
import stud.oiv.crud.dao.factory.DAOFactory;
import stud.oiv.crud.dao.LibrarianDAO;
import stud.oiv.crud.service.LibrarianService;
import stud.oiv.crud.service.LogicException;

import java.util.ArrayList;
import java.util.Comparator;

public class LibrarianServiceImpl implements LibrarianService {

    @Override
    public ArrayList<Librarian> getAllLibrarians()  throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibrarianDAO librarianDAO = daoFactory.getLibrarianDAO();
        ArrayList<Librarian> result;
        try
        {
            result = librarianDAO.getAll();
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
        return result;
    }

    @Override
    public void deleteLibrarianById(Integer id)  throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibrarianDAO librarianDAO = daoFactory.getLibrarianDAO();
        try
        {
            librarianDAO.deleteById(id);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
    }

    @Override
    public void deleteLibrarian(Librarian librarian)  throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibrarianDAO librarianDAO = daoFactory.getLibrarianDAO();
        try
        {
            librarianDAO.delete(librarian);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
    }

    @Override
    public void addLibrarian(Librarian librarian)  throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibrarianDAO librarianDAO = daoFactory.getLibrarianDAO();
        try
        {
            librarianDAO.create(librarian);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
    }

    @Override
    public void updateLibrarian(Integer id, Librarian librarian)  throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibrarianDAO librarianDAO = daoFactory.getLibrarianDAO();
        try
        {
            librarianDAO.updateById(id,librarian);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
    }

    @Override
    public  ArrayList<Librarian>  sortByFirstName()  throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibrarianDAO librarianDAO = daoFactory.getLibrarianDAO();
        ArrayList<Librarian> librarians = null;
        try
        {
            librarians = librarianDAO.getAll();
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
        librarians.sort(new LibrarianFirstNameComparator());
        return librarians;
    }

    class LibrarianFirstNameComparator implements Comparator<Librarian> {

        public int compare(Librarian a, Librarian b){

            return a.getFirstName().compareTo(b.getFirstName());
        }
    }
}
