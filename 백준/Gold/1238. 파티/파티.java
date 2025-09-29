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
    static int X;
    static int INF = 10000 * 100;
    static List<List<Point>> toX = new ArrayList<>();
    static List<List<Point>> fromX = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            toX.add(new ArrayList<>());
            fromX.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            toX.get(start).add(new Point(end, t));
            fromX.get(end).add(new Point(start, t));
        }

        int[] toXDist = dijkstra(toX); // N -> X
        int[] fromXDist = dijkstra(fromX); // X -> N

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, toXDist[i] + fromXDist[i]);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int[] dijkstra(List<List<Point>> graph) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        pq.offer(new Point(X, 0));
        dist[X] = 0;

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
                }
            }
        }

        return dist;
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