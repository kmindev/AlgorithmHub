import java.util.Scanner;
import java.util.Arrays;
// 100 x 100 배열에서 행, 열, 대각선의 합 중 최대값 구하기
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int t = sc.nextInt();
			int[][] arr = new int[100][100];
			
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int diagonalSum1 = 0;
			int diagonalSum2 = 0;
			int maxRowSum=Integer.MIN_VALUE;
			int maxColumnSume=Integer.MIN_VALUE;
			
			for(int i=0; i<arr.length; i++) {
				int rowSum = 0;
				int columnSum = 0;
				
				for(int j=0; j<arr[i].length; j++) {
					rowSum+=arr[i][j];
					columnSum+=arr[j][i];
				}
				if(rowSum>maxRowSum)
					maxRowSum=rowSum;
				if(columnSum>maxColumnSume)
					maxColumnSume=columnSum;
				
				diagonalSum1+=arr[i][i];
				diagonalSum2+=arr[i][100-1-i];
			}
			
			int[] max = {diagonalSum1, diagonalSum2, maxRowSum, maxColumnSume};
			Arrays.sort(max);
			
			System.out.println("#"+t+" "+max[3]);
			
		}
	}

}