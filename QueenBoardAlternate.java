import java.util.ArrayList;
import java.util.List;

public class QueenBoard{
  private List<String> illegalPoints;
  private int size;

  public QueenBoard(int size){
    		illegalPoints = new ArrayList<String>();
		this.size=size;
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
  private boolean removeQueen(int r , int c){
    if(illegalPoints.contains(r+ "" + c)){
      illegalPoints.remove(r + "" +c);
      return true;
    }
    return false;
  }

  public String toString(){
    String str = "";
    for(int i=0;i<size;i++){
      for(int j=0;j<size;j++){
        if(illegalPoints.contains(i+""+ j)){
          str+="Q ";
        }
        else {
          str+="_ ";
        }
      }
      str+="\n";
    }
  }

  public boolean solve(){
    if(illegalPoints.size()>0)throw new IllegalStateException("There is already a Queen");
    return 1==solveH(0,false,0);

  }
  private int solveH(int start,boolean integer, int sum){
    if(illegalPoints.size()==size){
	sum++;
	if(integer==false)
		return sum;
	else{
		String str = illegalPoints.get(illegalPoints.size()-1);
      		int next = str.charAt(0)+1;
      		removeQueen(str.charAt(0),str.charAt(1));
		return solveH(next,integer,sum);
	}
    }
    int column = illegalPoints.size();
    int i=start;
		while(i<size){
			if(addQueen(i,column))break;
			i++;
		}
    if(i==size){
      if(column==0)return sum;
      String str = illegalPoints.get(illegalPoints.size()-1);
      newStart = str.charAt(0)+1;
      removeQueen(str.charAt(0),str.charAt(1));
      return solveH(newStart,integer,sum);
    }
    else
      return solveH(0,integer,sum);
  }
  public int countSolutions(){
	if(illegalPoints.size()>0)throw new IllegalStateException("There is already a Queen");
	return solveH(0,true, 0);
  }
}
