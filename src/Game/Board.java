package Game;

import java.util.Scanner;

public class Board implements IBoard
{
	int[] board = new int[9];
	
	IPlayer [] player = new IPlayer[2];
	
	Scanner scanner;
	
	int play = 1;

	public void run(String title) 
	{
		System.out.println(title);
		this.selectPlayer();
		this.newBoard();
		this.drawBoard();
		this.game();
	}
	
	public void selectPlayer()
	{
		if(this.isOnePlayer()){
			this.player[0] = new Player("1");
			this.player[1] = this.setMachine(this.selectMachine());			
		}
		else{
			this.player[0] = new Player("1");
			this.player[1] = new Player("2");
		}
	}
	
	public void game()
	{
		try{
			this.runGame();
		}
		catch(EndGameException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void runGame() throws EndGameException
	{
		while(true){
			this.play();
			this.validateEndGame();
			this.nextPlayer();
		}
	}
	
	public void play()
	{
		int result = this.player[this.play - 1].play(board, this.play);
		this.board[result] = this.play;
		this.drawBoard();
	}
	
	public void nextPlayer()
	{
		this.play = (this.play % 2) + 1;
	}
	
	public void validateEndGame() throws EndGameException
	{
		if(this.validateWinner())
			throw new EndGameException(Text.winner(this.player[this.play - 1].getName()));
		if(this.validateEnd())
			throw new EndGameException(Text.TIED_GAME);
	}
	
	public boolean validateEnd()
	{
		for(int i = 0; i < this.board.length ;  i ++)
			if(this.board[i] == 0)
				return false;
		return true;
	}
	
	public boolean validateWinner() 
	{
		if((this.board[0] == this.board[1] && this.board[1] == this.board[2]) && this.board[0] == this.play)
			return true;
		
		if((this.board[3] == this.board[4] && this.board[4] == this.board[5]) && this.board[3] == this.play)
			return true;
		
		if((this.board[6] == this.board[7] && this.board[7] == this.board[8]) && this.board[6] == this.play)
			return true;
		
		if((this.board[0] == this.board[3] && this.board[3] == this.board[6]) && this.board[0] == this.play)
			return true;
		
		if((this.board[1] == this.board[4] && this.board[4] == this.board[7]) && this.board[1] == this.play)
			return true;
		
		if((this.board[2] == this.board[5] && this.board[5] == this.board[8]) && this.board[2] == this.play)
			return true;
		
		if((this.board[0] == this.board[4] && this.board[4] == this.board[8]) && this.board[0] == this.play)
			return true;
		
		if((this.board[2] == this.board[4] && this.board[4] == this.board[6]) && this.board[2] == this.play)
			return true;
		
		return false;		
	}
	
	public void newBoard()
	{
		for(int i = 0; i < 9 ;  i ++)
			this.board[i] = 0;
	}
	
	public void drawBoard()
	{
		for(int i = 0; i < 9; i++) {
			if((i + 1) % 3 == 0){
				System.out.println(this.drawParts(this.board[i], i));
			}
			else{
				System.out.print(this.drawParts(this.board[i], i)+"|");
			}
			if((i + 1) % 3 == 0 && i < 7){
				System.out.println("-----");
			}
		}
		System.out.println("");
	}
	
	public String drawParts(int opt, int i)
	{
		switch(opt){
			case 1:
				return Text.x;
			case 2: 
				return Text.o;
			default:
				return String.valueOf(i + 1);
		}	
	}
	
	public boolean isOnePlayer()
	{
		int player = 1;
		System.out.print(Text.PLAYER_OPTION);
		player = scannerInt();
		if(player < 1 || player > 2){
			System.out.println(Text.VALUE_INVALID);
			player = this.isOnePlayer() ? 1 : 2;
		}
		return (player == 1);
	}
	
	public int selectMachine()
	{
		int machine = 1;
		System.out.print(Text.MACHINE_OPTION);
		machine = scannerInt();
		if(machine < 1 || machine > 3){
			System.out.println(Text.VALUE_INVALID);
			machine = this.selectMachine();
		}
		return machine;
	}
	
	public IPlayer setMachine(int machine)
	{
		MachineFactory machineFactory = new MachineFactory();
		return machineFactory.create(machine);
	}
	
	public int scannerInt()
	{
		try {
			scanner = new Scanner(System.in);
			return scanner.nextInt();
		}
		catch(Exception e){
			return scannerInt();
		}
	}
}
