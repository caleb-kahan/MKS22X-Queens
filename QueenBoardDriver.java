public class QueenBoardDriver{
	public static void main(String [] args){
		QueenBoard chess = new QueenBoard(8);
		System.out.println(chess.countSolutions());
		System.out.println(chess.solve());
		System.out.println(chess);
	}
}
