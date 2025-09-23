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

    static int V;
    static int E;
    static int K;

    static List<List<Point>> graph = new ArrayList<>();
    static int[] result;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        result = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Point(v, w));
        }

        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(result[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static void dijkstra() {
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        boolean[] visited = new boolean[V + 1];
        pq.offer(new Point(K, 0));
        result[K] = 0;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();

            if (visited[cur.x]) {
                continue;
            }
            visited[cur.x] = true;

            for (Point next : graph.get(cur.x)) {
                if (result[next.x] > result[cur.x] + next.w) {
                    result[next.x] = result[cur.x] + next.w;
                    pq.add(new Point(next.x, result[next.x]));
                }
            }
        }
    }

    static class Point {
        int x;
        int w;

        public Point(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }
}