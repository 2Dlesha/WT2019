package stud.oiv.crud.beans.factory;

import stud.oiv.crud.beans.Book;

import java.util.HashMap;
import java.util.Map;

public class BookFactory {
    private static Map<String,BookCreator> creators = new HashMap<>();
    static {
        creators.put("Comics",new ComicsCreator());
        creators.put("StudyBook",new StudyBookCreator());
        creators.put("ArtBook",new ArtBookCreator());
    }

    public static Book createBook(String type,String fields)
    {
        BookCreator creator = creators.get(type);
        return creator.create(fields);
    }
}
