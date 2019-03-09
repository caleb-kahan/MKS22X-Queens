public class QueenBoardDriver{
	public static void main(String [] args){
		for(int i=11;i<15;i++){
			QueenBoard chess = new QueenBoard(i);
			System.out.println(chess.countSolutions());
			//System.out.println(chess.solve());
			//System.out.println(chess);
		}
		/*QueenBoard chess = new QueenBoard(9);
		System.out.println(chess.countSolutions());
		System.out.println(chess.solve());
		chess = new QueenBoard(10);
		System.out.println(chess.countSolutions());
		System.out.println(chess.solve());
		System.out.println(chess);
		chess = new QueenBoard(15);
		System.out.println(chess.solve());
		System.out.println(chess);
		chess = new QueenBoard(16);
		System.out.println(chess.solve());
		System.out.println(chess);
		chess = new QueenBoard(17);
		System.out.println(chess.solve());
		System.out.println(chess);
		runTest(0);
		runTest(1);
		runTest(2);
		runTest(3);
		runTest(4);
		runTest(5);*/
	}
	public static void runTest(int i){
  		QueenBoard b;
  		int[]tests =   {1,2,3,4,5,8};
  		int[]answers = {1,0,0,2,10,92};
  		if(i >= 0 && i < tests.length ){
    			int size = tests[i];
    			int correct = answers[i];
    			b = new QueenBoard(size);
    			int ans  = b.countSolutions();
    			if(correct==ans){
      			System.out.println("PASS board size: "+tests[i]+" "+ans);
    			}else{
      			System.out.println("FAIL board size: "+tests[i]+" "+ans+" vs "+correct);
    			}
  		}
	}
}
