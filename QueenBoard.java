import java.util.ArrayList;
import java.util.List;

public class QueenBoard{
  private int [][] board;
	private List<String> queenBoard;

	public QueenBoard(int size){
		board = new int[size][size]
		queenBoard = new ArrayList<String>();
	}

  private boolean addQueen(int r, int c){
		board[r][c]=1;

	}
}
