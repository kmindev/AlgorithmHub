import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            if (i < M) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = (dp[i - 1] + dp[i - M]) % 1000000007;
            }
        }

        bw.write(dp[N] + "");
        bw.flush();
        bw.close();
    }

}