package Game;

import java.util.Scanner;

public class Player implements IPlayer 
{
	String name;
	
	private Scanner scanner;
	
	int play;
	
	public Player(String playerNumber)
	{
		System.out.print("Digite o nome do player "+ playerNumber +":");
		this.name = this.scannerString();
	}
	
	public Player()
	{
		this("Player");
	}
	
	public int play(int[] game, int player) 
	{
		System.out.println(this.name);
		System.out.print("Posição:");
		this.play = this.scannerInt();
		if(this.play < 1 || this.play > 9 || game[this.play - 1] != 0 )
		{
			System.out.println(Text.VALUE_INVALID);
			return this.play(game, player);
		}
		return this.play - 1;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public String scannerString()
	{
		try {
			scanner = new Scanner(System.in);
			return scanner.nextLine();
		}
		catch(Exception e){
			System.out.println(Text.VALUE_INVALID);
			return this.scannerString();
		}
	}
	
	public int scannerInt()
	{
		try {
			scanner = new Scanner(System.in);
			return scanner.nextInt();
		}
		catch(Exception e){
			System.out.println(Text.VALUE_INVALID);
			return this.scannerInt();
		}
	}

}
