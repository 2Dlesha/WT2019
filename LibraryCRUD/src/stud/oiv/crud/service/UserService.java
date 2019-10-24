package stud.oiv.crud.service;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.User;

import java.util.ArrayList;

public interface UserService {
    ArrayList<User> getAllUsers();
    User getUser(Integer Id);
    void addUser(User user);
    void updateUser(Integer id,User user);
    void deleteUserById(Integer id);
    void deleteUser(User user);
    void addBookToUser(User user, Book book);
    void deleteBookFromUser(User user, Book book);
    ArrayList<Book> getUserBooks(User user);
    ArrayList<User> sortByFirstName();
    ArrayList<User> sortByAddress();
    ArrayList<User> findByFirstName(String name);
}

