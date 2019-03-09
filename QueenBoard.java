import java.util.ArrayList;
import java.util.List;

/*Commented Out stuff is your special stuff.*/

public class QueenBoard{
  //public int [][] board;
  public List<String> illegalPoints;
  public int size;
  //

  public QueenBoard(int size){
    //board = new int[size][size];
    illegalPoints = new ArrayList<String>();
    this.size=size;
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
  private boolean findSlope(String ab, String xy){
    int x = Character.getNumericValue(xy.charAt(0));
    int y = Character.getNumericValue(xy.charAt(1));
    int a = Character.getNumericValue(ab.charAt(0));
    int b = Character.getNumericValue(ab.charAt(1));
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
  public boolean addQueen(String rc){
		for(String str: illegalPoints){
			if(! findSlope(rc,str))
				return false;

		}
		illegalPoints.add(rc);
		return true;
	}
  public boolean removeQueen(String xy){
    if(illegalPoints.contains(xy)){
      illegalPoints.remove(xy);
      return true;
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
		return solveH();

	}
  /*public boolean solve(){
    for(int [] row: board){
      for(int value: row){
        if(value!=0)throw new IllegalStateException("Board has a non-0 Value");
      }
    }
    return 1==solveH(0,0, false, 0);
  }*/
  private boolean solveH(){
    /*System.out.println(Text.go(1,1));
    System.out.println(this);
    Text.wait(50);*/
    int column = illegalPoints.size();
    if(column == size){
      return true;
      //String row = illegalPoints.get(size-1).substring(0,1);
      //removeQueen(row+column);

    }
    
    int i = 0;
    while(i < size){
      if(addQueen(i+""+column)){
	if(solveH()) return true;
	removeQueen(i+""+column);
      } 
      i++;
    }
    return false;
  }
  private int countH(int sum){
    if(illegalPoints.size() == size) return ++sum;
    int column = illegalPoints.size();
    int i = 0;
    while(i < size){
      if(addQueen(i+""+column)){
	sum+=countH(0);
      	removeQueen(i+""+column);
      }
      i++;
    }
    return sum;
  }
  /*private void clear(){
	for(int i=0;i<board.length;i++){
		for(int j=0;j<board[0].length;j++){
			board[i][j]=0;
		}
	}
  }*/
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
      if(illegalPoints.size() > 0) throw new IllegalStateException("There is already a Queen");
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
