package stud.oiv.crud.service;

import stud.oiv.crud.beans.Librarian;

import java.util.ArrayList;

public interface LibrarianService {
    ArrayList<Librarian> getAllLibrarians();
    void deleteLibrarianById(Integer id);
    void deleteLibrarian(Librarian librarian);
    void addLibrarian(Librarian librarian);
    void updateLibrarian(Integer id,Librarian librarian);
    ArrayList<Librarian> sortByFirstName();
}
