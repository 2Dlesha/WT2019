package stud.oiv.crud.dao;

import stud.oiv.crud.beans.User;

import java.util.ArrayList;

public interface UserDAO {

    ArrayList<User> getAll();

    User getById(Integer id);

    User update(User user);

    boolean deleteById(Integer id);

    boolean delete(User user);

    boolean create(User user);
}
