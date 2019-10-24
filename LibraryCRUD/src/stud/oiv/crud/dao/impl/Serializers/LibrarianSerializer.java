package stud.oiv.crud.dao.impl.Serializers;

import stud.oiv.crud.beans.Librarian;

public class LibrarianSerializer {

    private String delimeter = "&";

    public Librarian ParseLibrarian(String librarianAsString)
    {
        String[] librarianInfo = librarianAsString.split(delimeter);

        if(librarianInfo.length != 5)
            return null;

        Librarian result = new Librarian(librarianInfo[2],librarianInfo[3],librarianInfo[4]);
        result.setId(Integer.parseInt(librarianInfo[1]));
        return result;
    }

    //Librarian|id|FirstName|LastName|Phone
    public String FormatLibrarian(Librarian librarian)
    {
        String result = null;
        result = "Librarian" + delimeter + librarian.getId() + delimeter + librarian.getFirstName() + delimeter + librarian.getLastName() + delimeter + librarian.getPhoneNumber();
        return result;
    }
}
