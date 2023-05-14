import java.util.Scanner;

// 파스칼의 삼각형
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			System.out.println("#"+tc);
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<=i; j++) {
					if(j==0 || j==i)
						arr[i][j] = 1;
					else {
						arr[i][j]= arr[i-1][j-1] + arr[i-1][j];
					}
				}
			}
			
			for(int i=0; i<arr.length;i++) {
				for(int j=0; j<arr[i].length; j++) {
					if(arr[i][j]>0)
						System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			} 
		}

	}

}