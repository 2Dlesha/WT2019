package stud.oiv.crud.dao.impl.Serializers;

import stud.oiv.crud.beans.Book;

public abstract class BookSerializer{

   abstract Book ParseBook(String bookAsString);
   abstract String FormatBook(Book book);

}

