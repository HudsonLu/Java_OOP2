package CheckedExceptions;
public class MissingFieldException extends Exception 
{
	public MissingFieldException(String message) 
	{
        super(message);
    }
}