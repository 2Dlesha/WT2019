package stud.oiv.crud.view.console;

import stud.oiv.crud.beans.ArtBook;
import stud.oiv.crud.beans.Comics;
import stud.oiv.crud.beans.StudyBook;

import java.util.HashMap;
import java.util.Map;

public class BookViewFactory {

    static Map<String, BookView> states = new HashMap<String, BookView>(){};

    static {
        states.put(Comics.class.getSimpleName(),new ComicsView());
        states.put(ArtBook.class.getSimpleName(),new ArtBookView());
        states.put(StudyBook.class.getSimpleName(),new StudyBookView());
    }

    public static BookView GetView(String bookGenre)
    {
        return states.get(bookGenre);
    }
}
