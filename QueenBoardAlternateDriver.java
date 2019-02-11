public class QueenBoardAlternateDriver{
	public static void main(String [] args){
		QueenBoardAlternate chess = new QueenBoardAlternate(8);
		System.out.println(chess.countSolutions());
		System.out.println(chess.solve());
	}
}
