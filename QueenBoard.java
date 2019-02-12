import java.util.ArrayList;
import java.util.List;

/*Commented Out stuff is your marking stuff.*/

public class QueenBoard{
  //private int [][] board;
  private List<String> illegalPoints;
	private int size;

  public QueenBoard(int size){
    //board = new int[size][size];
    illegalPoints = new ArrayList<String>();
		this.size=size;
  }

  /*private boolean addQueen(int r, int c){
    if(board[r][c]==0){
      board[r][c]=-1;
      addMarks(r,c,true);
      return true;
    }
    else
    return false;
  }*/
  private boolean findSlope(int x, int y, String xy){
    int a = Character.getNumericValue(xy.charAt(0));
    int b = Character.getNumericValue(xy.charAt(1));
    if( x == a || y == b || Math.abs(y-b) == Math.abs(x-a)) return false;
    return true;
  }
  /*private void addMarks(int r, int c, boolean add){
    int changer = (add) ? 1 : -1;
    for(int i=1;c+i<board.length;i++){
      if(r-i>-1)
      board[r-i][c+i]+=changer;
      board[r][c+i]+=changer;
      if(r+i<board.length)
      board[r+i][c+i]+=changer;
    }
  }*/
  private boolean addQueen(int r, int c){
		for(String str: illegalPoints){
			if(! findSlope(r,c,str))
			return false;

		}
		illegalPoints.add(r + "" +c);
		return true;
	}
  private boolean removeQueen(String xy){
    if(illegalPoints.contains(xy)){
      illegalPoints.remove(xy);
      return true;
    }
    return false;
  }

  /*private boolean removeQueen(int r, int c){
    if(board[r][c]==-1){
      board[r][c]=0;
      addMarks(r,c,false);
      return true;
    }
    return false;
  }*/
  public String toString(){
    String str = "";
    for(int i=0; i<size; i++){
      for(int j=0; j<size; j++){
        if(illegalPoints.contains(i + "" + j)){
          str += "Q ";
        }
        else {
          str += "_ ";
        }
      }
      str += "\n";
    }
    return str;
  }
  /*public String toString(){
    //TWO-D Array Version
    String str = "";
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board.length;j++){
        if(board[i][j]==-1){
          str+="Q ";
        }
        else {
          str+="_ ";
        }
      }
      str+="\n";
    }
    return str;
  }*/
  public boolean solve(){
		if(illegalPoints.size() > 0) throw new IllegalStateException("There is already a Queen");
		return 1 == solveH(0, false, 0);

	}
  /*public boolean solve(){
    for(int [] row: board){
      for(int value: row){
        if(value!=0)throw new IllegalStateException("Board has a non-0 Value");
      }
    }
    return 1==solveH(0,0, false, 0);
  }*/
  private int solveH(int row, boolean retNumSolutions, int sum){
    if(row==size && illegalPoints.size()==0){
        return sum;
    }
    if(illegalPoints.size() == size){
      sum++;
      if(retNumSolutions==false){
        return sum;
      }
      else{
        String str = illegalPoints.get(illegalPoints.size() - 1);
        int nextRow = Character.getNumericValue(str.charAt(0)) + 1;
        if(! removeQueen(str)) return -1;
        return solveH(nextRow, retNumSolutions, sum);
      }
    }
    int column = illegalPoints.size();
    int i = row;
    while(i < size){
      if(addQueen(i, column)) break;
      i++;
    }
    if(i == size){
      String str = illegalPoints.get(illegalPoints.size()-1);
      int newStart = Character.getNumericValue(str.charAt(0)) + 1;
      removeQueen(str);
      return solveH(newStart, retNumSolutions, sum);
    }
    else
      return solveH(0, retNumSolutions, sum);
  }
  /*private int solveH(int row, int column, boolean integer, int sum){
    if(row==board.length && column==0){
        return sum;
    }
    if(column==board.length) {
      sum++;
      if(integer==false)
        return sum;
      else{
        for(int j=0;j<board.length;j++){
          if(board[j][column-1]==-1){
            removeQueen(j,column-1);
            return solveH(j+1,column-1,true,sum);
          }
        }
      }
    }
      int i=row;
      while(i<board.length){
        if(addQueen(i,column))break;
        i++;
      }
      if(i==board.length){
        for(int j=0;j<board.length;j++){
          if(board[j][column-1]==-1){
            removeQueen(j,column-1);
            return solveH(j+1,column-1,integer,sum);
          }
        }
      }
      return solveH(0,column+1,integer,sum);
    }*/
    public int countSolutions(){
      if(illegalPoints.size() > 0) throw new IllegalStateException("There is already a Queen");
      return solveH(0, true, 0);
    }
    /*public int countSolutions(){
      for(int [] row: board){
        for(int value: row){
          if(value!=0)throw new IllegalStateException("Board has a non-0 Value");
        }
      }
      return solveH(0,0, true, 0);
    }*/
  }
