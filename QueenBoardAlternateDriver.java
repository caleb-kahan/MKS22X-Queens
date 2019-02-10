public class QueenBoardAlternateDriver{
	public static void main(String [] args){
		QueenBoard chess = new QueenBoardAlternate(8);
		System.out.println(chess.countSolutions());
	}
}
