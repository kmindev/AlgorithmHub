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
    static int E;

    static List<List<Point>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;

    static final int INF = 200000 * 1000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Point(b, c));
            graph.get(b).add(new Point(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, N);

        int result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);

        if (result1 >= INF && result2 >= INF) {
            bw.write("-1\n");
        } else {
            bw.write(Math.min(result1, result2) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);

        pq.offer(new Point(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (visited[cur.end]) {
                continue;
            }
            visited[cur.end] = true;

            for (Point next : graph.get(cur.end)) {
                if (dist[next.end] > dist[cur.end] + next.w) {
                    dist[next.end] = dist[cur.end] + next.w;
                    pq.offer(new Point(next.end, dist[next.end]));
                }
            }
        }
        return dist[end];
    }

    static class Point {
        int end;
        int w;

        public Point(int end, int w) {
            this.end = end;
            this.w = w;
        }
    }
}