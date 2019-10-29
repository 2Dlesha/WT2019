package stud.oiv.crud.service;

import stud.oiv.crud.beans.Librarian;

import java.util.ArrayList;

public interface LibrarianService {

    /**
     * <p>Метод возвращает всех библиотекарей</p>
     */
    ArrayList<Librarian> getAllLibrarians() throws LogicException;

    /**
     * <p>Метод удаляет библиотекаря с заданным id</p>
     * @param id id библиотекаря
     */
    void deleteLibrarianById(Integer id) throws LogicException;

    /**
     * <p>Метод удаляет библиотекаря</p>
     */
    void deleteLibrarian(Librarian librarian) throws LogicException;

    /**
     * <p>Метод добавляет нового библиотекаря</p>
     * @param librarian поля с информацией об библиотекаре
     */
    void addLibrarian(Librarian librarian) throws LogicException;

    /**
     * <p>Метод обновляет поля заданного библиотекаря</p>
     * @param id id обновляемого библиотекаря
     * @param librarian поля с новой информацией
     */
    void updateLibrarian(Integer id,Librarian librarian) throws LogicException;

    /**
     * <p>Метод возвращает библиотекарей, отсортированных по имени</p>
     */
    ArrayList<Librarian> sortByFirstName() throws LogicException;
}
