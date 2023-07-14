import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 화폐의 가치 N개
        int m = Integer.parseInt(st.nextToken()); // 만들고자 하는 금액

        int[] coinTypes = new int[n];
        int[] dp = new int[m + 1];

        for (int i = 0; i < n; i++)
            coinTypes[i] = Integer.parseInt(br.readLine());

        Arrays.fill(dp, 100000);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = coinTypes[i]; j <= m; j++) {
                if (dp[j - coinTypes[i]] != 100000)  // 금액을 만들 수 있는 경우
                    dp[j] = Math.min(dp[j], dp[j - coinTypes[i]] + 1);
            }
        }

        System.out.println(dp[m] != 100000 ? dp[m] : -1);

    }
}
