package stud.oiv.crud.service.impl;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.dao.BookDAO;
import stud.oiv.crud.dao.factory.DAOFactory;
import stud.oiv.crud.service.LibraryService;

import java.util.ArrayList;

public class LibraryServiceImpl implements LibraryService {
    @Override
    public Book getBook(Integer id) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        return bookDAO.getById(id);
    }

    @Override
    public void addBook(Book book) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        bookDAO.create(book);
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        return bookDAO.getAll();
    }

    @Override
    public void update(Integer id, Book book) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        bookDAO.update(id,book);
    }

    @Override
    public void deleteBook(Book book) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        bookDAO.delete(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        bookDAO.deleteById(id);
    }
}
