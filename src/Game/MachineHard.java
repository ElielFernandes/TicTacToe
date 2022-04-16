package Game;

public class MachineHard extends Machine
{
	public MachineHard(String name)
	{
		this.name = name;
	}
	
	public MachineHard()
	{
		this("MachineHard");
	}
	
	public int calculatePlay(int[] game)
    {
        int[] result = this.calculate(game, 2);
        int[][] calc = this.minimax(result);
        return calc[1][1];
    }
    
    public int[] calculate(int[] board, int j)
    {
        int [] result = new int [9];
        for(int i = 0; i < 9; i ++)
        {
            if(board[i] == 0)
            {
                board[i] = j;
                if(this.validateWinner(board, j))
                    result[i] = this.scoreValue(j , 1);
                else
                    if(this.validateEnd(board))
                        result[i] = 0;
                    else
                    {
                        int[] r = this.calculate(board, this.j(j));
                        int[][] calc = this.minimax(r);
                        result[i] = calc[this.j(j) - 1][0];
                    }
                board[i] = 0;
            }
            else
                result[i] = this.scoreValue(j , -2);
        }
        return result;
    }
    
    public int j(int j)
    {
        return ((j) % 2) + 1;
    }
    
    public int scoreValue(int j ,int value)
    {
        return j == 2 ? value : value * -1;
    }
    
    public int[][] minimax(int[] score)
    {
        int[][] minimax = new int [2][2];
        minimax[0][0] = minimax[1][0] = score[0];
        minimax[0][1] = minimax[1][1] = 0;
        for(int j = 0; j < 9; j++)
        {
            if(score[j] >  minimax[1][0])
            {
                minimax[1][0] = score[j];
                minimax[1][1] = j;
            }
            if(score[j] <  minimax[0][0])
            {
                minimax[0][0] = score[j];
                minimax[0][1] = j;
            }
        }
        return minimax;
    }
    
    public boolean validateWinner(int [] board, int j)
    {
        if(board[0] == board[1] && board[1] == board[2] && board[0] == j)
            return true;
            
        if(board[3] == board[4] && board[4] == board[5] && board[3] == j)
            return true;
            
        if(board[6] == board[7] && board[7] == board[8] && board[6] == j)
            return true;
            
        if(board[0] == board[3] && board[3] == board[6] && board[0] == j)
            return true;
            
        if(board[1] == board[4] && board[4] == board[7] && board[1] == j)
            return true;
            
        if(board[2] == board[5] && board[5] == board[8] && board[2] == j)
            return true;
            
        if(board[0] == board[4] && board[4] == board[8] && board[0] == j)
            return true;
            
        if(board[2] == board[4] && board[4] == board[6] && board[2] == j)
            return true;
        
        return false;
    }
    
    public boolean validateEnd(int [] board)
    {
        for(int j = 0; j < 9; j++){
            if(board[j] == 0){
                return false;
            }
        } 
        return true;
    }
}
