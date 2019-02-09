public class QueenBoard{
  private int [][] board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
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
  private boolean removeQueen(int r, int c){
    if(board[r][c]==-1){
      board[r][c]=0;
      addMarks(r,c,false);
      return true;
    }
    return false;
  }
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

  public boolean solve(){
    for(int [] row: board){
      for(int value: row){
        if(value!=0)throw new IllegalStateException("Board has a non-0 Value");
      }
    }
    return 1==solveH(0,0, false, 0);
  }

  private int solveH(int row, int column, boolean integer, int sum){
    if(column==board.length) {
	sum++;
	if(integer==false)
		return sum;
	else{
		for(int j=0;j<board.length;j++){
        		if(board[j][column-1]==-1){
          			removeQueen(j,column-1);
          			return solveH(row+1,column-1,true,sum);
        	}	}
      	}
    }		
    int i=row;
    while(! addQueen(i,column) && i<board.length)
      i++;
    if(i==board.length){
      if(column==0)return sum;
      for(int j=0;j<board.length;j++){
        if(board[j][column-1]==-1){
          removeQueen(j,column-1);
          return solveH(row+1,column-1,integer,sum);
        }
      }
    }
    else
      return solveH(0,column+1,integer,sum);
  }
  public int countSolutions(){
    for(int [] row: board){
      for(int value: row){
        if(value!=0)throw new IllegalStateException("Board has a non-0 Value");
      }
    }
    return solveH(0,0, true, 0);
  }
}
