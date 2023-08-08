import java.io.*;
import java.util.Arrays;

class Main {
    private static int[][] dp = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = i;
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        
        for (int tc = 0; tc < t; tc++) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호

            sb.append(dp[k][n] + "\n");
        }

        System.out.println(sb);
    }
}