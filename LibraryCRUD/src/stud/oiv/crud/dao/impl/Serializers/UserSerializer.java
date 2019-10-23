package stud.oiv.crud.dao.impl.Serializers;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.User;

import java.util.ArrayList;

public class UserSerializer {

    private String delimeter = "&";

    public User ParseUser(String userAsString)
    {
        String[] userInfo = userAsString.split(delimeter);

        if(userInfo.length != 6)
            return null;

        User result = new User(userInfo[2],userInfo[3],userInfo[4],userInfo[1],new ArrayList<Book>());
        result.setId(Integer.parseInt(userInfo[1]));
        return result;
    }

    //User|id|FirstName|LastName|DateOfMembership|Address
    public String FormatUser(User user)
    {
        String result = null;
        result = "User" + delimeter + user.getId() + delimeter + user.getFirstName() + delimeter + user.getLastName() + delimeter + user.getDateOfMembership() + delimeter + user.getAddress();
        return result;
    }
}
