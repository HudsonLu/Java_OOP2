package CheckedExceptions;
public class TooManyFieldsException extends Exception
{
    public TooManyFieldsException(String message) {
        super(message);
    }
}