import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int S;
    static int COUNT;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        COUNT = S == 0 ? COUNT - 1 : COUNT;
        System.out.println(COUNT);
    }

    static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                COUNT++;
            }
            return;
        }

        dfs(depth + 1, sum + numbers[depth]);
        dfs(depth + 1, sum);
    }
}