package stud.oiv.crud.service.impl;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.dao.BookDAO;
import stud.oiv.crud.dao.DAOException;
import stud.oiv.crud.dao.factory.DAOFactory;
import stud.oiv.crud.service.LibraryService;
import stud.oiv.crud.service.LogicException;

import java.util.ArrayList;
import java.util.Comparator;

public class LibraryServiceImpl implements LibraryService {
    @Override
    public Book getBook(Integer id) throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        Book result;
        try
        {
            result = bookDAO.getById(id);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
        return result;
    }

    @Override
    public void addBook(Book book) throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        try
        {
            bookDAO.create(book);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
    }

    @Override
    public ArrayList<Book> getAllBooks() throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        ArrayList<Book> allBooks;
        try
        {
            allBooks =  bookDAO.getAll();
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
        return  allBooks;
    }

    @Override
    public void update(Integer id, Book book) throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();

        try
        {
            bookDAO.update(id,book);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
    }

    @Override
    public void deleteBook(Book book) throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        try
        {
            bookDAO.delete(book);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
    }

    @Override
    public void deleteBookById(Integer id) throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        try
        {
            bookDAO.deleteById(id);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
    }

    @Override
    public ArrayList<Book> sortByPageCount() throws LogicException
    {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        ArrayList<Book> allBooks;
        try
        {
            allBooks =  bookDAO.getAll();
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
        allBooks.sort(new BookPageComparator());
        return allBooks;
    }

    @Override
    public ArrayList<Book> sortByAuthor() throws LogicException
    {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        ArrayList<Book> allBooks;
        try
        {
            allBooks =  bookDAO.getAll();
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
        allBooks.sort(new BookAuthorComparator());
        return allBooks;
    }

    @Override
    public ArrayList<Book> findByName(String name) throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        ArrayList<Book> allBooks;
        try
        {
            allBooks =  bookDAO.getAll();
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
        ArrayList<Book> findUsers = new ArrayList<>();
        for (Book book:allBooks)
        {
            if(book.getName().equals(name))
                findUsers.add(book);
        }
        return findUsers;
    }

    class BookPageComparator implements Comparator<Book> {

        public int compare(Book a, Book b){

            if(a.getPageCount()> b.getPageCount())
                return 1;
            else if(a.getPageCount()< b.getPageCount())
                return -1;
            else
                return 0;
        }
    }

    class BookAuthorComparator implements Comparator<Book>{

        public int compare(Book a, Book b){

            return a.getAuthor().compareTo(b.getAuthor());
        }
    }
}
