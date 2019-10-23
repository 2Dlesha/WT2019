package stud.oiv.crud.dao;

import stud.oiv.crud.beans.Librarian;

import java.util.ArrayList;

public interface LibrarianDAO {

    ArrayList<Librarian> getAll();

    Librarian getById(Integer id);

    Librarian updateById(Integer id,Librarian librarian);

    boolean deleteById(Integer id);

    boolean delete(Librarian librarian);

    boolean create(Librarian librarian);
}
