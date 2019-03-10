import java.util.ArrayList;
import java.util.*;

/*Commented Out stuff is your special stuff.*/

public class QueenBoard{
  //public int [][] board;
  private int [] illegalPoints;

  public QueenBoard(int size){
    //board = new int[size][size];
    illegalPoints = new int [size];
    for(int i=0;i<size;i++){
      illegalPoints[i]=-1;
    }
  }

  /*public boolean addQueen(int r, int c){
    if(board[r][c]==0){
      board[r][c]=-1;
      addMarks(r,c,true);
      return true;
    }
    else
    return false;
  }*/
  private boolean findSlope(int x, int y, int a, int b){
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
  */
  private boolean addQueen(int row, int column){
  /*System.out.println(Text.go(1,1));
    System.out.println(this);
    Text.wait(50);*/
    for(int i=0;i<illegalPoints.length;i++){
      if(illegalPoints[i]!=-1 && ! findSlope(illegalPoints[i],i,row,column))
				return false;
    }
		illegalPoints[column]=row;
		return true;
	}
  private boolean removeQueen(int row, int column){
    /*System.out.println(Text.go(1,1));
    System.out.println(this);
    Text.wait(50);*/
    for(int i =0;i<illegalPoints.length;i++){
      if(i==column && illegalPoints[i]==row){
        illegalPoints[i]=-1;
        return true;
      }
    }

    return false;
  }

  /*public boolean removeQueen(int r, int c){
    if(board[r][c]==-1){
      board[r][c]=0;
      addMarks(r,c,false);
      return true;
    }
    return false;
  }*/
  public String toString(){
    String str = "";
    for(int i=0; i<illegalPoints.length; i++){
      for(int j=0; j<illegalPoints.length; j++){
        if(illegalPoints[j]==i){
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
    for(int i=0;i<illegalPoints.length;i++){
        	if(illegalPoints[i] != -1) throw new IllegalStateException("There is already a Queen");
    }
		boolean solvable = solveH(0);
    if(solvable==false){
      clear();
    }
    return true;
	}
  /*public boolean solve(){
    for(int [] row: board){
      for(int value: row){
        if(value!=0)throw new IllegalStateException("Board has a non-0 Value");
      }
    }
    return 1==solveH(0,0, false, 0);
  }*/
  private boolean solveH(int column){
    int size = illegalPoints.length;
    if(column == size){
      return true;
    }
    int i = 0;
    while(i < size){
      if(addQueen(i,column)){
	if(solveH(column+1)) return true;
	removeQueen(i,column);
      }
      i++;
    }
    return false;
  }
  private int countH(int sum){
    int size = illegalPoints.length;
    int column =0;
    for(int i=0;i<size;i++){
        	if(illegalPoints[i]>-1) column++;
    }
    if(column==size)return ++sum;
    int i = 0;
    while(i < size){
      if(addQueen(i,column)){
	       sum+=countH(0);
      	removeQueen(i,column);
      }
      i++;
    }
    return sum;
  }
  private void clear(){
	for(int i=0;i<illegalPoints.length;i++){
			illegalPoints[i]=-1;
		}
  }
  /*private int solveH(int row, int column, boolean integer, int sum){
    if(row==board.length && column==0){
        return sum;
    }
    if(column==board.length) {
      sum++;
      if(integer==false){
	if(sum==0)clear();
        return sum;
      }
      else{
	int rowStart =0;
        for(int j=0;j<board.length;j++){
          if(board[j][column-1]==-1) removeQueen(j,column-1);
	  if(board[j][column-2]==-1) {
		rowStart=j+1;
		removeQueen(j,column-2);
	  }

         }
	return solveH(rowStart,column-2,integer,sum);
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
      for(int i=0;i<illegalPoints.length;i++){
          	if(illegalPoints[i] != -1) throw new IllegalStateException("There is already a Queen");
      }
      return countH(0);
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
