package stud.oiv.crud.service.impl;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.User;
import stud.oiv.crud.dao.factory.DAOFactory;
import stud.oiv.crud.dao.UserDAO;
import stud.oiv.crud.service.UserService;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {
    @Override
    public ArrayList<User> getAllUsers() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        return userDAO.getAll();
    }

    @Override
    public User getUser(Integer id) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        return userDAO.getById(id);
    }

    @Override
    public void addUser(User user) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        userDAO.create(user);
    }

    @Override
    public void updateUser(Integer id, User user) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        userDAO.update(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        userDAO.deleteById(id);
    }

    @Override
    public void deleteUser(User user) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        userDAO.delete(user);
    }

    @Override
    public void addBookToUser(User user, Book book) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
    }

    @Override
    public void deleteBookFromUser(User user, Book book) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
    }

    @Override
    public ArrayList<Book> getUserBooks(User user) {
        return null;
    }
}
