import java.util.ArrayList;
import java.util.List;

public class QueenBoardAlternate{
	private List<String> illegalPoints;
	private int size;

	public QueenBoardAlternate(int size){
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
		int a = Character.getNumericValue(xy.charAt(0));
		int b = Character.getNumericValue(xy.charAt(1));
		if( x == a || y == b || Math.abs(y-b) == Math.abs(x-a)) return false;
		return true;
	}

	private boolean removeQueen(String xy){
		if(illegalPoints.contains(xy)){
			illegalPoints.remove(xy);
			return true;
		}
		return false;
	}

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

	public boolean solve(){
		if(illegalPoints.size() > 0) throw new IllegalStateException("There is already a Queen");
		return 1 == solveH(0, false, 0);

	}
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
	public int countSolutions(){
		if(illegalPoints.size() > 0) throw new IllegalStateException("There is already a Queen");
		return solveH(0, true, 0);
	}
}
