package stud.oiv.crud.dao.impl;

import stud.oiv.crud.beans.Identifier;
import stud.oiv.crud.beans.Librarian;
import stud.oiv.crud.constants.Settings;
import stud.oiv.crud.dao.DAOException;
import stud.oiv.crud.dao.impl.Serializers.LibrarianSerializer;
import stud.oiv.crud.dao.LibrarianDAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class FileLibrarianDAO implements LibrarianDAO {

    private ArrayList<Librarian> librariansCash = null;

    @Override
    public ArrayList<Librarian> getAll()throws DAOException {
        ArrayList<Librarian> librarians = getAllLibrarians();
        return (ArrayList<Librarian>) librarians.clone();
    }

    public ArrayList<Librarian> getAllLibrarians() throws DAOException{
        if(librariansCash != null)
          return librariansCash;
        ArrayList<Librarian> librarians = new ArrayList<>();
        BufferedReader buff = null;
        FileReader myFile = null;

        try
        {
            myFile = new FileReader(Settings.SourceFilePath + "\\librarians.txt");
            buff = new BufferedReader(myFile);
            while (true)
            {
                String line = buff.readLine();
                if (line == null)
                    break;

                LibrarianSerializer librarianSerializer = new LibrarianSerializer();
                librarians.add(librarianSerializer.ParseLibrarian(line));
                //System.out.println(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new DAOException(e);
        }
        finally
        {
            try
            {
                buff.close();
                myFile.close();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
                throw new DAOException(e1);
            }
        }
        librariansCash = librarians;
        return librarians;
    }

    @Override
    public Librarian getById(Integer id) throws DAOException {
        Librarian result = null;
        ArrayList<Librarian> allLibrarians = getAllLibrarians();
        for(Librarian librarian : allLibrarians)
        {
            if(librarian.getId() == id)
                result = librarian;
        }
        return result;
    }

    @Override
    public Librarian updateById(Integer id,Librarian librarian) throws DAOException {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) throws DAOException {
        ArrayList<Librarian> allLibrarians = getAllLibrarians();
        for(int i = 0; i < allLibrarians.size();i++)
        {
            if(allLibrarians.get(i).getId() == id)
            {
                allLibrarians.remove(i);
                break;
            }
        }
        saveLibrarianToFile(allLibrarians);
        librariansCash = null;
        return true;
    }

    @Override
    public boolean delete(Librarian librarian) throws DAOException {
        return false;
    }

    @Override
    public boolean create(Librarian librarian) throws DAOException {
        ArrayList<Librarian> librarians = getAllLibrarians();
        //librarian.setId(getUniqueId(librarians));
        librarian.setId(Identifier.getUniq(new ArrayList<>(librarians)));
        librarians.add(librarian);
        saveLibrarianToFile(librarians);
        return true;
    }

    public void saveLibrarianToFile(ArrayList<Librarian> librarians) throws DAOException
    {
        try(FileWriter writer = new FileWriter(Settings.SourceFilePath + "\\librarians.txt", false))
        {
            for(Librarian librarian: librarians)
            {
                LibrarianSerializer librarianSerializer= new LibrarianSerializer();
                writer.write(librarianSerializer.FormatLibrarian(librarian));
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
            throw new DAOException(ex);
        }
    }

}
