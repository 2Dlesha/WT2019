package stud.oiv.crud.service;

import stud.oiv.crud.beans.Book;

import java.util.ArrayList;

public interface LibraryService {
    Book getBook(Integer Id);
    void addBook(Book book);
    ArrayList<Book> getAllBooks();
    void update(Integer id,Book book);
    void deleteBook(Book book);
    void deleteBookById(Integer id);
}
