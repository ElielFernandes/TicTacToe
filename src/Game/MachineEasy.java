package Game;

public class MachineEasy extends Machine {

	public MachineEasy(String name)
	{
		this.name = name;
	}
	
	public MachineEasy()
	{
		this("MachineEasy");
	}
	
	public int calculatePlay(int[] game)
	{
		int move = 0;
		for(int i = 0; i < 9 ; i++) {
			if(game[i] == 0){
				move = i;
				break;
			}
		}
		return move;
	}

}
