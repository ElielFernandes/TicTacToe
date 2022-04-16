package Game;

public class BoardFactory 
{
	public IBoard create()
	{
		return new Board();
	}
}
