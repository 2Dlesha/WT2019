package stud.oiv.crud.dao.impl;

import stud.oiv.crud.beans.Identifier;
import stud.oiv.crud.beans.Librarian;
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
    public ArrayList<Librarian> getAll() {
        ArrayList<Librarian> librarians = getAllLibrarians();
        return (ArrayList<Librarian>) librarians.clone();
    }

    public ArrayList<Librarian> getAllLibrarians() {
        if(librariansCash != null)
          return librariansCash;
        ArrayList<Librarian> librarians = new ArrayList<>();
        BufferedReader buff = null;
        FileReader myFile = null;

        try
        {
            myFile = new FileReader("D:\\Study\\University\\5 term\\WT\\LibraryCRUD\\src\\librarians.txt");
            buff = new BufferedReader(myFile);
            while (true)
            {
                String line = buff.readLine();
                if (line == null)
                    break;

                LibrarianSerializer librarianSerializer = new LibrarianSerializer();
                librarians.add(librarianSerializer.ParseLibrarian(line));
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
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
            }
        }
        librariansCash = librarians;
        return librarians;
    }

    @Override
    public Librarian getById(Integer id) {
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
    public Librarian updateById(Integer id,Librarian librarian) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
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
    public boolean delete(Librarian librarian) {
        return false;
    }

    @Override
    public boolean create(Librarian librarian) {
        ArrayList<Librarian> librarians = getAllLibrarians();
        librarian.setId(getUniqueId(librarians));
        librarians.add(librarian);
        saveLibrarianToFile(librarians);
        return true;
    }

    public void saveLibrarianToFile(ArrayList<Librarian> librarians)
    {
        try(FileWriter writer = new FileWriter("D:\\Study\\University\\5 term\\WT\\LibraryCRUD\\src\\librarians.txt", false))
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
        }
    }

    private int getUniqueId(ArrayList<Librarian> librarians)
    {
        Random random = new Random(System.currentTimeMillis());
        boolean isUniq;
        int uniqId;
        do {
            isUniq = true;
            uniqId = random.nextInt();
            for (Identifier identifier : librarians) {
                if (identifier.getId() == uniqId)
                    isUniq = false;
            }
        }while (isUniq);
        return uniqId;
    }
}
