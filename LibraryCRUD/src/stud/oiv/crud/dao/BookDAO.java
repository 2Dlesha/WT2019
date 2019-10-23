package stud.oiv.crud.dao;

import stud.oiv.crud.beans.Book;

import java.util.ArrayList;

public interface BookDAO{

    ArrayList<Book> getAll();

    Book getById(Integer id);

    Book update(Integer id,Book book);

    boolean deleteById(Integer id);

    boolean delete(Book book);

    boolean create(Book entity);
}
