package Game;

final public class Text {
	
	final static String PLAYER_OPTION = "1 - Player \n2 - Player \nSelecione uma opção:";

	final static String MACHINE_OPTION = "1 - Machine Easy \n2 - Machine Moderate \n3 - Machine Hard \nSelecione uma opção:";
	
	final static String VALUE_INVALID = "Valor invalido.";
	
	final static String TIED_GAME = "empate.";
	
	final static String x = "X";
	
	final static String o = "O";
	
	public static String winner(String winner)
	{
		return winner + " ganhou!!!";
	}
}
