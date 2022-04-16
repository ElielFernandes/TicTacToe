package Game;

import java.util.Random;

public class MachineModerate extends Machine {

	public MachineModerate(String name)
	{
		this.name = name;
	}
	
	public MachineModerate()
	{
		this("MachineModerate");
	}
	
	public int calculatePlay(int[] game)
	{
		while(true){
			this.move  = calculate(0,8);
			if(game[this.move] == 0)
				break;	
		}
		return this.move;
	}
	
	public int calculate(int minimum, int maximum) 
	 {
		 Random random = new Random();
	     return random.nextInt((maximum - minimum) + 1) + minimum;
	 }

}
