package stud.oiv.crud.dao;

import stud.oiv.crud.beans.Book;

import java.util.ArrayList;

public interface BookDAO{

    ArrayList<Book> getAll()  throws DAOException ;

    Book getById(Integer id)  throws DAOException ;

    Book update(Integer id,Book book) throws DAOException ;

    boolean deleteById(Integer id) throws DAOException ;

    boolean delete(Book book) throws DAOException ;

    boolean create(Book entity) throws DAOException ;
}
