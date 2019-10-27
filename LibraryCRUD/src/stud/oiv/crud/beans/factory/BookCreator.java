package stud.oiv.crud.beans.factory;

import stud.oiv.crud.beans.Book;

public abstract class BookCreator {
    public abstract Book create(String fields);
}
