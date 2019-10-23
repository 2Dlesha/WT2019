package stud.oiv.crud.beans;

import java.util.ArrayList;

public  class User extends Identifier implements Comparable<User>
{

    private String FirstName;
    private String LastName;
    private String DateOfMembership;
    private String Address;
    private ArrayList<Book> books;

    public User(String firstName, String lastName, String dateOfMembership, String address, ArrayList<Book> books)
    {
        FirstName = firstName;
        LastName = lastName;
        DateOfMembership = dateOfMembership;
        Address = address;
        this.books = books;
    }

    public String getFirstName()
    {
        return FirstName;
    }

    public void setFirstName(String firstName)
    {
        FirstName = firstName;
    }

    public String getLastName()
    {
        return LastName;
    }

    public void setLastName(String lastName)
    {
        LastName = lastName;
    }

    public String getDateOfMembership()
    {
        return DateOfMembership;
    }

    public void setDateOfMembership(String dateOfMembership)
    {
        DateOfMembership = dateOfMembership;
    }

    public String getAddress()
    {
        return Address;
    }

    public void setAddress(String address)
    {
        Address = address;
    }

    public ArrayList<Book> getBooks()
    {
        return books;
    }

    public void setBooks(ArrayList<Book> books)
    {
        this.books = books;
    }

    @Override
    public int compareTo(User o) {
        return LastName.compareTo(o.getLastName());
    }

    @Override
    public String toString() {
        return this.getId() + " " + LastName + " " + FirstName;
    }
}
