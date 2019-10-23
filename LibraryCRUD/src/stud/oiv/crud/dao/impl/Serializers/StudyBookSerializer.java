package stud.oiv.crud.dao.impl.Serializers;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.StudyBook;

public class StudyBookSerializer extends BookSerializer {

    private String delimeter = "&";

//StudyBook|Subject|Name|PageCount|Author|Id
    @Override
    public Book ParseBook(String bookAsString)
    {
        String[] bookInfo = bookAsString.split(delimeter);

        if(bookInfo.length != 6)
            return null;

        Book result = null;
        result = new StudyBook(bookInfo[2],Integer.parseInt(bookInfo[3]),bookInfo[4],bookInfo[1]);
        result.setId(Integer.parseInt(bookInfo[5]));
        return result;
    }

    @Override
    public String FormatBook(Book book)
    {
        if(!(book instanceof StudyBook))
            return null;

        StudyBook studyBook = (StudyBook)book;

        String result = null;
        result = "StudyBook" + delimeter + studyBook.getSubject() + delimeter + studyBook.getName() + delimeter + studyBook.getPageCount() + delimeter + studyBook.getAuthor() + delimeter + studyBook.getId() ;
        return result;
    }
}
