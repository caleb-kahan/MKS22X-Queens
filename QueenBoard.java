import java.util.ArrayList;
import java.util.List;

public class QueenBoard{
  private int [][] board;
  private List<String> illegalPoints;

  public QueenBoard(int size){
	board = new int[size][size];
  }

  private boolean addQueenProper(int r, int c){
	if(board[r][c]==0){
		board[r][c]=-1;
  		addMarks(r,c);
		return true;
	}
    	else return false;
  private void addMarks(int r, int c, boolean add?){
	int changer = (add?) ? 1 : -1;
	for(int i=1;i++;i<board.size-c-1){
		board[r-i][c+i]+=changer;
		board[r][c+i]+=changer;
		board[r+i][c+i]+=changer;
	}
  }
  private boolean addQueen(int r, int c){
    
    for(String str: illegalPoints){
    	if(! findSlope(r,c,str){
      	    return false;
	}
    }
    illegalPoints.add(r + "" +c);
    return true;
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
