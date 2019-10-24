package stud.oiv.crud.service.impl;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.dao.BookDAO;
import stud.oiv.crud.dao.factory.DAOFactory;
import stud.oiv.crud.service.LibraryService;

import java.util.ArrayList;
import java.util.Comparator;

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

    @Override
    public ArrayList<Book> sortByPageCount()
    {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        ArrayList<Book> allusers =  bookDAO.getAll();
        allusers.sort(new BookPageComparator());
        return allusers;
    }

    @Override
    public ArrayList<Book> sortByAuthor()
    {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        ArrayList<Book> allBooks =  bookDAO.getAll();
        allBooks.sort(new BookAuthorComparator());
        return allBooks;
    }

    @Override
    public ArrayList<Book> findByName(String name) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        ArrayList<Book> allBooks =  bookDAO.getAll();
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
