package Game;

public class Main 
{
	public static void main(String[] args) 
	{
		BoardFactory  borderFactory= new BoardFactory();
		IBoard board = borderFactory.create();
		board.run("Tic Tac Toe");
	}
}
