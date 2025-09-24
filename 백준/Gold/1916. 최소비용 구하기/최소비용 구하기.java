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

    static int N;
    static int M;

    static List<List<Point>> graph = new ArrayList<>();
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Point(end, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int result = dijkstra(start, end);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.offer(new Point(start, 0));
        result[start] = 0;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();

            if (visited[cur.end]) {
                continue;
            }

            visited[cur.end] = true;

            for (Point next : graph.get(cur.end)) {
                if (result[next.end] > result[cur.end] + next.w) {
                    result[next.end] = result[cur.end] + next.w;
                    pq.offer(new Point(next.end, result[next.end]));
                }
            }
        }
        return result[end];
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