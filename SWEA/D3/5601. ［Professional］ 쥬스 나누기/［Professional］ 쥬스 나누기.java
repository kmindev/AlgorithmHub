import java.util.Scanner;

// 쥬스 나누기
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			System.out.print("#"+tc+" ");
			for (int i = 0; i < N; i++) {
				System.out.printf("%d/%d ", 1, N);
			}
			System.out.println();
		}

	}

}