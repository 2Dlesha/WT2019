package stud.oiv.crud.beans.factory;

import stud.oiv.crud.beans.ArtBook;
import stud.oiv.crud.beans.Book;

import java.util.Scanner;

public class ArtBookCreator extends BookCreator {
    @Override
    public Book create(String fields) {
        String bookFields[] = fields.split("&");
        if(bookFields.length != 4)
            return null;
        return new ArtBook(bookFields[0],Integer.parseInt(bookFields[1]),bookFields[2],bookFields[3]);
    }
}
