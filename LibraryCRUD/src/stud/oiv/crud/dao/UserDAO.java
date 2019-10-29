package stud.oiv.crud.dao;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.User;

import java.util.ArrayList;

public interface UserDAO {

    ArrayList<User> getAll() throws DAOException ;

    User getById(Integer id) throws DAOException ;

    User update(User user) throws DAOException ;

    boolean deleteById(Integer id) throws DAOException ;

    boolean delete(User user) throws DAOException ;

    boolean create(User user) throws DAOException ;

    boolean addBookToUser(Integer userId, Integer bookId) throws DAOException ;

    boolean RemoveBookFromUser(Integer userId, Integer bookId) throws DAOException ;
}
