package stud.oiv.crud.dao.impl.Serializers;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.Comics;

public class ComicsSerializer extends BookSerializer
{

    private String delimeter = "&";
    //Comics|Genre|Type|Name|PageCount|Author|Id

    @Override
    public Book ParseBook(String bookAsString)
    {
        String[] bookInfo = bookAsString.split(delimeter);

        if(bookInfo.length != 7)
            return null;

        Book result = null;
        result = new Comics(bookInfo[3],Integer.parseInt(bookInfo[4]),bookInfo[5],bookInfo[1],bookInfo[2]);
        result.setId(Integer.parseInt(bookInfo[6]));
        return result;
    }

    @Override
    public String FormatBook(Book book)
    {
        if(!(book instanceof Comics))
            return null;

        Comics comics = (Comics)book;

        String result = null;
        result = "Comics" + delimeter + comics.getGenre() + delimeter + comics.getType() + delimeter + comics.getName() + delimeter + comics.getPageCount() + delimeter + comics.getAuthor() + delimeter + comics.getId() ;
        return result;
    }
}
