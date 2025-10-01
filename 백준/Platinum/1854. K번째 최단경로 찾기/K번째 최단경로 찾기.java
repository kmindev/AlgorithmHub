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
    static int K;

    static List<List<Point>> graph = new ArrayList<>();
    static List<PriorityQueue<Integer>> distQueue = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            distQueue.add(new PriorityQueue<>(K, (o1, o2) -> o1 < o2 ? 1 : -1));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Point(b, c));
        }

        dijkstra(1);

        for (int i = 1; i <= N; i++) {
            if (distQueue.get(i).size() == K) {
                int result = distQueue.get(i).peek();
                bw.write(result + "\n");
            } else {
                bw.write("-1\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(start, 0));
        distQueue.get(start).offer(0);

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            for (Point next : graph.get(cur.x)) {
                if (distQueue.get(next.x).size() < K) {
                    distQueue.get(next.x).offer(cur.w + next.w);
                    pq.offer(new Point(next.x, cur.w + next.w));
                } else if (distQueue.get(next.x).peek() > cur.w + next.w) {
                    distQueue.get(next.x).poll();
                    distQueue.get(next.x).offer(cur.w + next.w);
                    pq.offer(new Point(next.x, cur.w + next.w));
                }
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int w;

        Point(int x, int w) {
            this.x = x;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return this.w - o.w;
        }
    }
}