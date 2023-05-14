import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int[][] sudoku = new int[9][9];
			boolean answer = true;

			for (int i = 0; i < sudoku.length; i++) {
				for (int j = 0; j < sudoku[i].length; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}

			// 각 행의 합을 구해서 45가 아니면 answer = false
			for (int i = 0; i < sudoku.length; i++) {
				int rowSum = 0;
				int columnSum = 0;
				for (int j = 0; j < sudoku[i].length; j++) {
					rowSum += sudoku[i][j];
					columnSum += sudoku[j][i];
				}
				if (rowSum != 45 || columnSum != 45) {
					answer = false;
					break;
				}
			}
			
			if(answer==false) {
				System.out.println("#"+(tc+1)+" "+0);
				continue;
			}
			
			// 3 x 3 배열의 합이 45가 아닐 때
			
			for(int i=0; i<9; i+=3) {
				
				for(int j=0; j<9; j+=3) {
					int sum = 0;
					for(int x=0; x<3; x++) {
						for(int y=0; y<3; y++) {
							sum+=sudoku[x+i][y+j];
						}
					}
					if(sum!=45) {
						answer = false;
						break;
					}
				}
				if(answer==false)
					break;
			}
			if(answer==true) 
				System.out.println("#"+(tc+1)+" "+1);
			else 
				System.out.println("#"+(tc+1)+" "+0);
			
			

		}
	}

}
