package stud.oiv.crud.dao;

import stud.oiv.crud.beans.Librarian;

import java.util.ArrayList;

public interface LibrarianDAO {

    ArrayList<Librarian> getAll() throws DAOException ;

    Librarian getById(Integer id) throws DAOException ;

    Librarian updateById(Integer id,Librarian librarian) throws DAOException ;

    boolean deleteById(Integer id) throws DAOException ;

    boolean delete(Librarian librarian) throws DAOException ;

    boolean create(Librarian librarian) throws DAOException ;
}
