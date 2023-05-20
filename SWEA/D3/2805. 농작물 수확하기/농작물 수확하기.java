import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for (int i = 0; i < arr.length; i++) {
                String input = sc.next();
                for (int j = 0; j < arr[i].length; j++) {  // 입력
                    arr[i][j] = input.charAt(j) - '0';
                }
            }

            int sum = 0;
            // 가운데 기점으로 위, 아래에 해당하는 index는 서로 같음
            for (int i = 0; i < arr.length / 2; i++) {
                for (int j = N / 2 - i; j <= N / 2 + i; j++) {
                    sum += arr[i][j] + arr[N - i - 1][j];
                }
            }

            // 가운데 부분
            for (int i = 0; i < arr[N / 2].length; i++) {
                sum += arr[N / 2][i];
            }

            System.out.println("#" + tc + " " + sum);

        }


    }

}