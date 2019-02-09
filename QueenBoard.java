import java.util.ArrayList;
import java.util.List;

public class QueenBoard{
  private int [][] board;
  private List<String> illegalPoints;

  public QueenBoard(int size){
	board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
		board[r][c]=-1;
    if(findSlope){
      illegalPoints.add(r + "" +c);
      return true;
    }
    return false;
  private boolean findSlope(int x, int y, String xy){
    double a = str.charAt(0);
    double b = str.charAt(1);
    double slope = (y-b)/(x-a);
    if(Math.abs(slope)==1 || slope ==0) return false;
    return true;
  }
  private boolean removeQueen(int r, int c){
    board[r][c]=1;
  }




}
