package CheckedExceptions;
public class UnknownGenreException extends Exception 
{
    public UnknownGenreException(String message) {
        super(message);
    }
}