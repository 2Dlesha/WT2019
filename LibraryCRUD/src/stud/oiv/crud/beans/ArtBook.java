package stud.oiv.crud.beans;

public class ArtBook extends Book
{
    private String Genre;

    public ArtBook( String name, int pageCount, String author, String genre)
    {
        super( name, pageCount, author);
        Genre = genre;
    }

    public String getGenre()
    {
        return Genre;
    }

    public void setGenre(String genre)
    {
        Genre = genre;
    }
}
