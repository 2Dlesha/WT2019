package stud.oiv.crud.beans;

public  class Comics extends Book
{
    private String Genre;
    private String Type; // enum

    public Comics(String name, int pageCount, String author, String genre, String type) {
        super(name, pageCount, author);
        Genre = genre;
        Type = type;
    }

    public String getGenre()
    {
        return Genre;
    }

    public void setGenre(String genre)
    {
        Genre = genre;
    }

    public String getType()
    {
        return Type;
    }

    public void setType(String type)
    {
        Type = type;
    }
}
