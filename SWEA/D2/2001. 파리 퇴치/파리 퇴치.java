import java.util.Scanner;

// 파리채
public class Solution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 배열 크기
            int M = sc.nextInt(); // 파리채 크기
            int[][] arr = new int[N][N];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int max = 0;
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = 0;
                    for (int x = 0; x < M; x++) {
                        for (int y = 0; y < M; y++) {
                            sum += arr[i + x][j + y];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
            System.out.println("#" + tc + " " + max);
        }


    }

}
