package Game;

public class MachineFactory 
{
	final int MACHINE_EASY = 1;
	
	final int MACHINE_MODERATE = 2;
	
	final int MACHINE_HARD = 3;
	
	public IPlayer create(int machine)
	{		
		switch(machine) 
		{
			case MACHINE_EASY:
				return new MachineEasy();
				
			case MACHINE_MODERATE:
				return new MachineModerate();
				
			case MACHINE_HARD:
				return new MachineHard();
				
			default:
				return new MachineEasy();
		}
	}
}
