package stud.oiv.crud.dao.impl;

import stud.oiv.crud.beans.Identifier;
import stud.oiv.crud.beans.User;
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

    public ArrayList<User> getAll() {
        ArrayList<User> users = getAllUsers();
        return (ArrayList<User>)users.clone();
    }

    private ArrayList<User> getAllUsers() {
        if (usersCash != null)
            return usersCash;
        ArrayList<User> users = new ArrayList<>();
        BufferedReader buff = null;
        FileReader myFile = null;

        try
        {
            myFile = new FileReader("D:\\Study\\University\\5 term\\WT\\LibraryCRUD\\src\\users.txt");
            buff = new BufferedReader(myFile);
            while (true)
            {
                String line = buff.readLine();
                if (line == null)
                    break;

                UserSerializer userSerializer = new UserSerializer();
                users.add(userSerializer.ParseUser(line));
                //System.out.println(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
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
            }
        }

        usersCash = users;
        return usersCash;
    }

    @Override
    public User getById(Integer id) {
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
    public User update(User user) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
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
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean create(User user) {
        ArrayList<User> allusers = getAllUsers();
        user.setId(getUniqueId(allusers));
        allusers.add(user);
        saveUsersToFile(allusers);
        usersCash = null;
        return true;
    }


    public void saveUsersToFile(ArrayList<User> users)
    {
        try(FileWriter writer = new FileWriter("D:\\Study\\University\\5 term\\WT\\LibraryCRUD\\src\\users.txt", false))
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
        }
    }

    private int getUniqueId(ArrayList<User> users)
    {
        Random random = new Random(System.currentTimeMillis());
        boolean isUniq;
        int uniqId;
        do {
            isUniq = true;
            uniqId = random.nextInt();
            for (Identifier identifier : users) {
                if (identifier.getId() == uniqId)
                    isUniq = false;
            }
        }while (isUniq);
        return uniqId;
    }
}
