import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int inf = 10000 * 1000;
            List<List<Point>> graph = new ArrayList<>();
            int[] dist = new int[n + 1];
            boolean[] visited = new boolean[n + 1];

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
                dist[i] = inf;
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph.get(b).add(new Point(a, s));
            }

            dijkstra(graph, dist, visited, c);

            int count = 0;
            int max = Integer.MIN_VALUE;

            for (int i = 1; i <= n; i++) {
                if (dist[i] >= inf) {
                    continue;
                }

                count++;
                max = Math.max(max, dist[i]);
            }
            bw.write(count + " " + max + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(List<List<Point>> graph, int[] dist, boolean[] visited, int start) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
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