package stud.oiv.crud.service;

public class LogicException extends Exception {
    public LogicException()
    {
        super();
    }

    public LogicException(String message)
    {   super(message);
    }

    public LogicException(Exception e)
    {
        super(e);
    }

    public LogicException(String message, Exception e)
    {
        super(message, e);
    }
}
