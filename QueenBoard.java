import java.util.ArrayList;
import java.util.List;

public class QueenBoard{
  private int [][] board;
  private List<Integer> illegalRows;
  private List<Integer> illegalColumns;

	public QueenBoard(int size){
		board = new int[size][size];
	}

  private boolean addQueen(int r, int c){
		board[r][c]=1;

	}
  private int[] illegalRows(){
		List illegal = new ArrayList<Integer>();
		for(String str: queenBoard){
      illegal.add(str.charAt(0))
    }
  }
}
