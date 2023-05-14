import java.util.Scanner;

// 숫자 배열 회전
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int[][] result_90 = rotation(arr);
			int[][] result_180 = rotation(result_90);
			int[][] result_270 = rotation(result_180);
            
            System.out.printf("#%d\n", tc+1);
            
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(result_90[i][j]);
				}
				System.out.print(" ");

				for (int j = 0; j < N; j++) {
					System.out.print(result_180[i][j]);
				}
				System.out.print(" ");

				for (int j = 0; j < N; j++) {
					System.out.print(result_270[i][j]);
				}
				System.out.println();
			}

//			System.out.println(Arrays.deepToString(arr));
		}

	}

	private static int[][] rotation(int[][] arr) {
		int[][] result = new int[arr.length][arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				result[i][j] = arr[arr.length - j - 1][i];
			}
		}
		return result;
	}

}
