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
    static int[] dist;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dist = new int[10000];
        for (int i = 0; i < 10000; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph.get(end).add(new Point(start, distance));
        }

        dist[0] = 0;
        for (int i = 1; i <= D; i++) {
            dist[i] = dist[i - 1] + 1;
            for (Point next : graph.get(i)) {
                dist[i] = Math.min(dist[i], dist[next.start] + next.distance);
            }
        }

        bw.write(dist[D] + "");
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