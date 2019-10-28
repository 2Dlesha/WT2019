package stud.oiv.crud.dao.impl.Serializers;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.User;

import java.util.ArrayList;

public class UserSerializer {

    private String delimeter = "&";
    private String bookDelimeter = "%";


    public User ParseUser(String userAsString,ArrayList<Book> availibleBooks)
    {
        String[] userInfo = userAsString.split(delimeter);

        if(userInfo.length != 7 && userInfo.length != 6)
            return null;

        User result = new User(userInfo[2],userInfo[3],userInfo[4],userInfo[5],null);

        if(userInfo.length == 6)
            result.setBooks(new ArrayList<Book>());
        else
            result.setBooks(ParseUserBooks(userInfo[6],availibleBooks));

        result.setId(Integer.parseInt(userInfo[1]));
        return result;
    }

    //User|id|FirstName|LastName|DateOfMembership|Address
    public String FormatUser(User user)
    {
        String result = null;
        result = String.join(delimeter,"User",Integer.toString(user.getId()),user.getFirstName(),user.getLastName(),user.getDateOfMembership(),user.getAddress(),FormatUserBooks(user.getBooks()));
       // result = "User" + delimeter + user.getId() + delimeter + user.getFirstName() + delimeter + user.getLastName() + delimeter + user.getDateOfMembership() + delimeter + user.getAddress();
        return result;
    }

    private String FormatUserBooks(ArrayList<Book> books)
    {
        String result = "";
        for(Book book: books)
        {
            result += book.getId() + bookDelimeter;
        }
        return result;
    }

    private ArrayList<Book> ParseUserBooks(String books,ArrayList<Book> availibleBooks)
    {
        ArrayList<Book> result = new ArrayList<>();
        String[] userBooks = books.split(bookDelimeter);
        for(String bookId: userBooks)
        {
            int id = Integer.parseInt(bookId);
            for(Book book: availibleBooks)
            {
                if(book.getId() == id)
                    result.add(book);
            }
        }
        return result;
    }
}
