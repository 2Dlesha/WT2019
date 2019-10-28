package stud.oiv.crud.service;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.User;

import java.util.ArrayList;

public interface UserService {
    /**
     * <p>Метод возвращает всех пользователей</p>
     */
    ArrayList<User> getAllUsers();

    /**
     * <p>Возвращает пользователя с заданным id</p>
     */
    User getUser(Integer Id);

    /**
     * <p>Метод создает нового пользователя</p>
     * @param user пользователь для добавления без id
     */
    void addUser(User user);

    /**
     * <p>Метод обновляет поля пользователя</p>
     * @param user пользователь с новыми полями
     * @param  id id пользователя для обновления
     */
    void updateUser(Integer id,User user);

    /**
     * <p>Метод удаляет пользователя</p>
     * @param  id id удаляемого пользователя
     */
    void deleteUserById(Integer id);

    void deleteUser(User user);

    /**
     * <p>Метод добавляет книгу в пользователя</p>
     * @param  userId id пользователя
     * @param  bookId id книги
     */
    void addBookToUser(Integer userId, Integer bookId);

    /**
     * <p>Метод удаляет книгу из пользователя</p>
     * @param  userId id пользователя
     * @param  bookId id книги
     */
    void deleteBookFromUser(Integer userId, Integer bookId);

    /**
     * <p>Метод возвращает книги пользователя</p>
     * @param  userId id пользователя
     */
    ArrayList<Book> getUserBooks(Integer userId);

    /**
     * <p>Метод возвращает пользоваелей, отсортированный по имени</p>
     */
    ArrayList<User> sortByFirstName();

    /**
     * <p>Метод возвращает пользоваелей, отсортированный по адресу</p>
     */
    ArrayList<User> sortByAddress();

    /**
     * <p>Метод возвращает пользоваелей с заданным именем</p>
     */
    ArrayList<User> findByFirstName(String name);
}

