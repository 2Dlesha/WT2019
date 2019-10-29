package stud.oiv.crud.dao.impl.Serializers;

import stud.oiv.crud.beans.ArtBook;
import stud.oiv.crud.beans.Book;

public class ArtBookSerializer extends BookSerializer {

    private String delimeter = "&";
    //ArtBook|Genre|Name|PageCount|Author|Id

    @Override
    public Book ParseBook(String bookAsString)
    {
        String[] bookInfo = bookAsString.split(delimeter);

        if(bookInfo.length != 6)
            return null;

        Book result = null;
        result = new ArtBook(bookInfo[2],Integer.parseInt(bookInfo[3]),bookInfo[4],bookInfo[1]);
        result.setId(Integer.parseInt(bookInfo[5]));
        return result;
    }

    @Override
    public String FormatBook(Book book)
    {
        if(!(book instanceof ArtBook))
            return null;

        ArtBook comics = (ArtBook)book;

        String result = "";
        result = "ArtBook" + delimeter + comics.getGenre() + delimeter + comics.getName() + delimeter + comics.getPageCount() + delimeter + comics.getAuthor() + delimeter + comics.getId() ;
        return result;
    }
}
