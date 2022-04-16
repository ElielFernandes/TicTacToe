package Game;

abstract class Machine implements IPlayer 
{
	String name;
	
	int player;
	
	int move;
	
	abstract public int calculatePlay(int[] game);
	
	public String getName() 
	{
		return this.name;
	}
	
	public int play(int[] game, int player) 
	{
		this.player = player;
		this.move = calculatePlay(game);
		System.out.println(this.name);
		System.out.println("posição: "+ this.move);
		return this.move;
	}
}
