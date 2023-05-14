import java.util.Arrays;

import java.util.Scanner;

// 파리채
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max = 0;
			int[][] arr = new int[N][N];

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int sum = 0;
					for (int x = 0; x < M; x++) {
						for (int y = 0; y < M; y++) {
							sum += arr[x + i][y + j];
						}
					}
					max = Math.max(sum, max);
				}
			}

			System.out.println("#" + (tc + 1) + " " + max);

		}
	}

}
