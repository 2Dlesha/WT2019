package stud.oiv.crud.dao.impl;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.Identifier;
import stud.oiv.crud.beans.User;
import stud.oiv.crud.constants.Settings;
import stud.oiv.crud.dao.DAOException;
import stud.oiv.crud.dao.factory.DAOFactory;
import stud.oiv.crud.dao.impl.Serializers.UserSerializer;
import stud.oiv.crud.dao.UserDAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FileUserDAO implements UserDAO {

    private ArrayList<User> usersCash = null;

    @Override

    public ArrayList<User> getAll() throws DAOException {
        ArrayList<User> users = getAllUsers();
        return (ArrayList<User>)users.clone();
    }

    private ArrayList<User> getAllUsers() throws DAOException {
        if (usersCash != null)
            return usersCash;
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Book> availibleBooks = DAOFactory.getInstance().getBookDAO().getAll();
        BufferedReader buff = null;
        FileReader myFile = null;

        try
        {
            myFile = new FileReader(Settings.SourceFilePath + "\\users.txt");
            buff = new BufferedReader(myFile);
            while (true)
            {
                String line = buff.readLine();
                if (line == null)
                    break;

                UserSerializer userSerializer = new UserSerializer();
                users.add(userSerializer.ParseUser( line, availibleBooks));
                //System.out.println(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new DAOException(e);
        }
        finally
        {
            try
            {
                buff.close();
                myFile.close();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
                throw new DAOException(e1);
            }
        }

        usersCash = users;
        return usersCash;
    }

    @Override
    public User getById(Integer id) throws DAOException {
        User result = null;
        ArrayList<User> allusers = getAllUsers();
        for(User user : allusers)
        {
            if(user.getId() == id)
                result = user;
        }
        return result;
    }

    @Override
    public User update(User user) throws DAOException  {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) throws DAOException  {
        ArrayList<User> allusers = getAllUsers();
        for(int i = 0; i < allusers.size();i++)
        {
            if(allusers.get(i).getId() == id)
            {
                allusers.remove(i);
                break;
            }
        }
        saveUsersToFile(allusers);
        usersCash = null;
        return true;
    }

    @Override
    public boolean delete(User user) throws DAOException {
        return false;
    }

    @Override
    public boolean create(User user) throws DAOException {
        ArrayList<User> allusers = getAllUsers();
        user.setId(Identifier.getUniq(new ArrayList<>(allusers)));
        //user.setId(getUniqueId(allusers));
        allusers.add(user);
        saveUsersToFile(allusers);
        usersCash = null;
        return true;
    }

    @Override
    public boolean addBookToUser(Integer userId, Integer bookId) throws DAOException {
        Book book = DAOFactory.getInstance().getBookDAO().getById(bookId);
        User user = getById(userId);
        if(book != null && user != null)
        {
            var userbooks = user.getBooks();
            userbooks.add(book);
            user.setBooks(userbooks);
            return true;
        }
        return false;
    }

    @Override
    public boolean RemoveBookFromUser(Integer userId, Integer bookId) throws DAOException {
        User user = getById(userId);
        if(user != null)
        {
            var userbooks = user.getBooks();
            for(int i = 0; i < userbooks.size();i++)
            {
                if(userbooks.get(i).getId() == bookId)
                {
                    userbooks.remove(i);
                    user.setBooks(userbooks);
                    return true;
                }
            }
        }
        return false;
    }


    public void saveUsersToFile(ArrayList<User> users) throws DAOException
    {
        try(FileWriter writer = new FileWriter(Settings.SourceFilePath + "\\users.txt", false))
        {
            for(User user: users)
            {
                UserSerializer userSerializer= new UserSerializer();
                writer.write(userSerializer.FormatUser(user));
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
            throw new DAOException(ex);
        }
    }

}
