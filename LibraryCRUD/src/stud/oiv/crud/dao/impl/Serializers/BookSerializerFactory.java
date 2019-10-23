package stud.oiv.crud.dao.impl.Serializers;

import stud.oiv.crud.beans.ArtBook;
import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.Comics;
import stud.oiv.crud.beans.StudyBook;

import java.util.HashMap;
import java.util.Map;

public class BookSerializerFactory{

    static Map<String, BookSerializer> states = new HashMap<String, BookSerializer>(){};

    //Comics|Genre|Type|Name|PageCount|Author|Id
    //ArtBook|Genre|Name|PageCount|Author|Id
    //StudyBook|Subject|Name|PageCount|Author|Id
    static {
        states.put(Comics.class.getSimpleName(),new ComicsSerializer());
        states.put(ArtBook.class.getSimpleName(),new ArtBookSerializer());
        states.put(StudyBook.class.getSimpleName(),new StudyBookSerializer());
    }

    public Book ParseBook(String bookAsString)
    {
        String[] bookInfo = bookAsString.split("&");
        BookSerializer bookSerializer = states.get(bookInfo[0]);
        return bookSerializer.ParseBook(bookAsString);
    }

    public String FormatBook(Book book)
    {
        BookSerializer bookSerializer = states.get(book.getClass().getSimpleName());
        return bookSerializer.FormatBook(book);
    }
}
