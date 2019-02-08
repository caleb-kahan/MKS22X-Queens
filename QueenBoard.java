import java.util.ArrayList;
import java.util.List;

public class QueenBoard{
  private int [][] board;
  private List<Integer> illegalRows;
  private List<Integer> illegalColumns;
  private List<String> illegalLines;

	public QueenBoard(int size){
		board = new int[size][size];
	}

  private boolean addQueen(int r, int c){
		board[r][c]=1;

	}
}
