package stud.oiv.crud.service.impl;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.User;
import stud.oiv.crud.dao.DAOException;
import stud.oiv.crud.dao.factory.DAOFactory;
import stud.oiv.crud.dao.UserDAO;
import stud.oiv.crud.service.LogicException;
import stud.oiv.crud.service.UserService;

import java.util.ArrayList;
import java.util.Comparator;

public class UserServiceImpl implements UserService {
    @Override
    public ArrayList<User> getAllUsers() throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        ArrayList<User> allUsers;
        try
        {
            allUsers =  userDAO.getAll();
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
        return allUsers;
    }

    @Override
    public User getUser(Integer id) throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        User result;
        try
        {
            result = userDAO.getById(id);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
        return result;
    }

    @Override
    public void addUser(User user) throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try
        {
            userDAO.create(user);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
    }

    @Override
    public void updateUser(Integer id, User user) throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try
        {
            userDAO.update(user);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
    }

    @Override
    public void deleteUserById(Integer id) throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try
        {
            userDAO.deleteById(id);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
    }

    @Override
    public void deleteUser(User user) throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try
        {
            userDAO.delete(user);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
    }

    @Override
    public void addBookToUser(Integer userId, Integer bookId) throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try
        {
            userDAO.addBookToUser(userId,bookId);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
    }

    @Override
    public void deleteBookFromUser(Integer userId, Integer bookId) throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try
        {
            userDAO.RemoveBookFromUser(userId,bookId);
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
    }

    @Override
    public ArrayList<Book> getUserBooks(Integer userId) throws LogicException {
       return getUser(userId).getBooks();
    }

    @Override
    public ArrayList<User> sortByFirstName() throws LogicException
    {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        ArrayList<User> allUsers;
        try
        {
            allUsers =  userDAO.getAll();
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
        allUsers.sort(new UserFirstNameComparator());
        return allUsers;
    }

    @Override
    public ArrayList<User> sortByAddress() throws LogicException
    {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        ArrayList<User> allUsers;
        try
        {
            allUsers =  userDAO.getAll();
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }
        allUsers.sort(new UserAddressComparator());
        return allUsers;
    }

    @Override
    public ArrayList<User> findByFirstName(String name) throws LogicException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();

        ArrayList<User> allUsers;
        try
        {
            allUsers =  userDAO.getAll();
        }
        catch (DAOException e)
        {
            throw new LogicException(e);
        }

        ArrayList<User> findUsers = new ArrayList<>();
        for (User user:allUsers)
        {
            if(user.getFirstName().equals(name))
                findUsers.add(user);
        }
        return findUsers;
    }

    class UserFirstNameComparator implements Comparator<User> {

        public int compare(User a, User b){

            return a.getFirstName().compareTo(b.getFirstName());
        }
    }

    class UserAddressComparator implements Comparator<User>{

        public int compare(User a, User b){

            return a.getAddress().compareTo(b.getAddress());
        }
    }

}
