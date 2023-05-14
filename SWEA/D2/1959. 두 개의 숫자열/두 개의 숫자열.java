import java.io.IOException;
import java.util.Scanner;


// 두개의 숫자열
public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] A = new int[N];
			int[] B = new int[M];

			int max = 0;

			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}

			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}

			if (M > N) {
				for (int i = 0; i < M - N + 1; i++) {
					int result = 0;
					for (int j = 0; j < N; j++) {
						result += A[j] * B[j + i];
					}
					max = Math.max(result, max);
				}
			}

			else if (N > M) {
				for (int i = 0; i < N - M + 1; i++) {
					int result = 0;
					for (int j = 0; j < M; j++) {
						result += B[j] * A[i + j];
					}
					max = Math.max(result, max);
				}
			}

			else {
				for (int i = 0; i < N; i++) {
					max += A[i] * B[i];
				}
			}

			System.out.println("#" + (tc + 1) + " " + max);
		}
	}
}