package stud.oiv.crud.beans.factory;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.Comics;
import stud.oiv.crud.beans.StudyBook;

import java.util.Scanner;

public class ComicsCreator extends BookCreator {
    @Override
    public Book create(String fields) {
        String bookFields[] = fields.split("&");
        if(bookFields.length != 5)
            return null;
        return new Comics(bookFields[0],Integer.parseInt(bookFields[1]),bookFields[2],bookFields[3],bookFields[4]);
    }
}
