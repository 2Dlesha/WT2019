package stud.oiv.crud.service.impl;

import stud.oiv.crud.beans.Librarian;
import stud.oiv.crud.dao.factory.DAOFactory;
import stud.oiv.crud.dao.LibrarianDAO;
import stud.oiv.crud.service.LibrarianService;

import java.util.ArrayList;

public class LibrarianServiceImpl implements LibrarianService {

    @Override
    public ArrayList<Librarian> getAllLibrarians() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibrarianDAO librarianDAO = daoFactory.getLibrarianDAO();
        return librarianDAO.getAll();
    }

    @Override
    public void deleteLibrarianById(Integer id) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibrarianDAO librarianDAO = daoFactory.getLibrarianDAO();
        librarianDAO.deleteById(id);
    }

    @Override
    public void deleteLibrarian(Librarian librarian) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibrarianDAO librarianDAO = daoFactory.getLibrarianDAO();
        librarianDAO.delete(librarian);
    }

    @Override
    public void addLibrarian(Librarian librarian) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibrarianDAO librarianDAO = daoFactory.getLibrarianDAO();
        librarianDAO.create(librarian);
    }

    @Override
    public void updateLibrarian(Integer id, Librarian librarian) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        LibrarianDAO librarianDAO = daoFactory.getLibrarianDAO();
        librarianDAO.updateById(id,librarian);
    }
}
