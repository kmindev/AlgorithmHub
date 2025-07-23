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
    static int MAX = Integer.MIN_VALUE;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(MAX);
    }

    static void dfs(int day, int sum) {
        if (day >= N) {
            MAX = Math.max(MAX, sum);
            return;
        }
        
        if (day + arr[day][0] <= N) { // 상담 가능한 경우
            dfs(day + arr[day][0], sum + arr[day][1]);
        }

        dfs(day + 1, sum); // 상담 X
    }
}