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
      addMarks(r,c,true);
      return true;
    }
    else
    return false;
  }
  private void addMarks(int r, int c, boolean add){
    int changer = (add) ? 1 : -1;
    for(int i=1;i<board.size-c-1;i++){
      board[r-i][c+i]+=changer;
      board[r][c+i]+=changer;
      board[r+i][c+i]+=changer;
    }
  }
  private boolean addQueen(int r, int c){
    for(String str: illegalPoints){
      if(! findSlope(r,c,str))
      return false;

    }
    illegalPoints.add(r + "" +c);
    return true;
  }
  private boolean findSlope(int x, int y, String xy){
    double a = str.charAt(0);
    double b = str.charAt(1);
    double slope = (y-b)/(x-a);
    if(Math.abs(slope)==1 || slope ==0) return false;
    return true;
  }
  private boolean removeQueenProper(int r, int c){
    if(board[r][c]==-1){
      board[r][c]=0;
      addMarks(r,c,false);
      return true;
    }
    return false;
  }
  private boolean removeQueen(int r , int c){
    if(illegalPoints.contains(r+ "" + c)){
      illegalPoints.remove(r + "" +c);
      return true;
    }
    return false;
  }

  /*public String toString(){
    //ONE-D Array Version
    String str = "";
    for(int i=0;i<board.size();i++){
      for(int j=0;j<board.size();j++){
        if(illegalPoints.contains(i+""+ j){
          str+="Q ";
        }
        else {
          str+="_ ";
        }
      }
      str+="\n";
    }
  }*/
  public String toString(){
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
  }
  /*public boolean solve(){
    if(illegalPoints.size()>0)throw new IllegalStateException("There is already a Queen");
    return solveH(0);

  }
  public boolean solveH(int start){
    if(illegalPoints.size()==board.length) return true;
    int column = illegalPoints.size();
    int i=start;
    while(! addQueen(i,column) && i<board.length)
    i++;
    if(i==board.length){
      if(column==0)return false;
      String str = illegalPoints.get(illegalPoints.size()-1);
      start = str.charAt(0)+1;
      removeQueen(str.charAt(0),str.charAt(1));
      return solveH(start);
    }
    else
      return solveH(0);
  }*/

  public boolean solve(){
    for(int [] row: board){
      for(int value: row){
        if(value!=0)throw new IllegalStateException("Board has a non-0 Value");
      }
    }
    return solveH(0,0);
  }

  public boolean solveH(int row, int column, boolean integer, int sum){
    if(column==board.length) return true;
    if(row==board.length) return false;
    int i=start;
    while(! addQueen(i,column) && i<board.length)
      i++;
    if(i==board.length){
      if(column==0)return false;
      for(int j=0;j<board.length;j++){
        if(board[j][column-1]==-1){
          removeQueen(j,column-1);
          return solveH(row+1,column-1);
        }
      }
    }
    else
      return solveH(0,column+1);
  }
  public int countSolutions(){

  }
}
