import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int M;
    static List<List<Point>> graph = new ArrayList<>();
    static int INF = Integer.MAX_VALUE;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Point(end, w));
            graph.get(end).add(new Point(start, w));
        }

        result = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    bw.write("- ");
                } else {
                    bw.write(result[i][j] + " ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int start) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.offer(new Point(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (visited[cur.x]) {
                continue;
            }
            visited[cur.x] = true;

            for (Point next : graph.get(cur.x)) {
                if (dist[next.x] > dist[cur.x] + next.w) {
                    dist[next.x] = dist[cur.x] + next.w;
                    pq.offer(new Point(next.x, dist[next.x]));
                    result[next.x][start] = cur.x;
                }
            }
        }
    }

    static class Point {
        int x;
        int w;

        Point(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }
}