package stud.oiv.crud.dao.impl;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.Identifier;
import stud.oiv.crud.dao.BookDAO;
import stud.oiv.crud.dao.impl.Serializers.BookSerializerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//Comics|Genre|Type|Name|PageCount|Author|Id
//ArtBook|Genre|Name|PageCount|Author|Id
//StudyBook|Subject|Name|PageCount|Author|Id

public class FileBookDAO implements BookDAO {

    private ArrayList<Book> booksCash = null;

    @Override
    public ArrayList<Book> getAll() {
        ArrayList<Book> books = getAllBooks();
        return (ArrayList<Book>) books.clone();
    }

    public ArrayList<Book> getAllBooks() {
        if(booksCash != null)
            return booksCash;

        ArrayList<Book> books = new ArrayList<Book>();

        BufferedReader buff = null;
        FileReader myFile = null;

        try
        {
            myFile = new FileReader("D:\\Study\\University\\5 term\\WT\\LibraryCRUD\\src\\books.txt");
            buff = new BufferedReader(myFile);
            while (true)
            {
                String line = buff.readLine();
                if (line == null)
                    break;

                BookSerializerFactory bookSerializerFactory = new BookSerializerFactory();
                books.add(bookSerializerFactory.ParseBook(line));
                //System.out.println(line);
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
        booksCash = books;
        return books;
    }


    @Override
    public Book getById(Integer id) {
        Book result = null;
        ArrayList<Book> allbooks = getAllBooks();
        for(Book book : allbooks)
        {
            if(book.getId() == id)
                result = book;
        }
        return result;
    }

    @Override
    public Book update(Integer id,Book book) {
        ArrayList<Book> allbooks = getAllBooks();
        for(int i = 0; i < allbooks.size();i++)
        {
            if(allbooks.get(i).getId() == id)
            {
                allbooks.set(i,book);
                return book;
            }
        };
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        ArrayList<Book> allbooks = getAllBooks();
        for(int i = 0; i < allbooks.size();i++)
        {
            if(allbooks.get(i).getId() == id)
            {
                allbooks.remove(i);
                break;
            }
        }
        saveBooksToFile(allbooks);
        return true;
    }

    @Override
    public boolean delete(Book book) {
        ArrayList<Book> allbooks = getAllBooks();
        allbooks.remove(book);
        saveBooksToFile(allbooks);

        return true;
    }

    @Override
    public boolean create(Book book) {
        ArrayList<Book> allbooks = getAllBooks();
        book.setId(Identifier.getUniq(new ArrayList<>(getAllBooks())));
        allbooks.add(book);
        saveBooksToFile(allbooks);
        return true;
    }


    public void saveBooksToFile(ArrayList<Book> books)
    {
        try(FileWriter writer = new FileWriter("D:\\Study\\University\\5 term\\WT\\LibraryCRUD\\src\\books.txt", false))
        {
            for(Book book: books)
            {
                BookSerializerFactory bookSerializerFactory = new BookSerializerFactory();
                writer.write(bookSerializerFactory.FormatBook(book));
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

}
