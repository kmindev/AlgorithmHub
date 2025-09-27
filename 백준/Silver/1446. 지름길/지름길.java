import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int D;

    static List<List<Point>> graph = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dp = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            if (end <= D) {
                graph.get(end).add(new Point(start, distance));
            }
        }

        dp[0] = 0;
        for (int i = 1; i <= D; i++) {
            dp[i] = dp[i - 1] + 1;
            for (Point next : graph.get(i)) {
                dp[i] = Math.min(dp[i], dp[next.start] + next.distance);
            }
        }

        bw.write(dp[D] + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int start;
        int distance;

        Point(int start, int distance) {
            this.start = start;
            this.distance = distance;
        }
    }
}