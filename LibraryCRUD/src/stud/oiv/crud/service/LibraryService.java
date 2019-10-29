package stud.oiv.crud.service;

import stud.oiv.crud.beans.Book;

import java.util.ArrayList;

public interface LibraryService {

    /**
     * <p>Метод возвращает книгу с заданным id</p>
     * @param Id id книги
     */
    Book getBook(Integer Id) throws LogicException;

    /**
     * <p>Метод создает книгу</p>
     * @param book информация о создаваемой книге
     */
    void addBook(Book book) throws LogicException;

    /**
     * <p>Метод возвращает все книги</p>
     */
    ArrayList<Book> getAllBooks() throws LogicException;

    /**
     * <p>обновляет информацию о книге</p>
     * @param id id обновляемой книги
     * @param book обновляемые поля книги
     */
    void update(Integer id,Book book) throws LogicException;

    /**
     * <p>Метод удаляет пользователя</p>
     */
    void deleteBook(Book book) throws LogicException;

    /**
     * <p>Метод удаляет пользователя</p>
     * @param id id удаляемого пользователя
     */
    void deleteBookById(Integer id) throws LogicException;

    /**
     * <p>Метод возвращает книгии отсортированный по кол-ву страниц</p>
     */
    ArrayList<Book> sortByPageCount() throws LogicException;

    /**
     * <p>Метод возвращает все книги с заданным автором</p>
     */
    ArrayList<Book> sortByAuthor() throws LogicException;

    /**
     * <p>Метод возвращает все книги с заданным именем</p>
     */
    ArrayList<Book> findByName(String name) throws LogicException;
}
