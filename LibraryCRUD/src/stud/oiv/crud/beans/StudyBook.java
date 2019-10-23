package stud.oiv.crud.beans;

public class StudyBook extends Book
{
    private String Subject;

    public StudyBook(String name, int pageCount, String author, String subject)
    {
        super(name, pageCount, author);
        Subject = subject;
    }

    public String getSubject()
    {
        return Subject;
    }

    public void setSubject(String subject)
    {
        Subject = subject;
    }
}
