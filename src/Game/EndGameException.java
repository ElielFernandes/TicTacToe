package Game;

public class EndGameException extends Exception 
{	
	private static final long serialVersionUID = 1L;
	
	String message;
	
	public EndGameException()
	{
		this("");
	}

	public EndGameException(String string) 
	{
		this.message = string;
	}
	
	public String getMessage()
	{
		return this.message;
	}
}
