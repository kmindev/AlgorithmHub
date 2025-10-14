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
    static int X;

    static int INF = 300_000;
    static int[] dist;
    static boolean[] visited;

    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            dist[i] = INF;
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, 1));
        }

        dijkstra(X);

        boolean flag = false;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == K) {
                flag = true;
                bw.write(i + "\n");
            }
        }

        if (!flag) {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.x]) {
                continue;
            }
            visited[cur.x] = true;

            for (Node next : graph.get(cur.x)) {
                if (dist[next.x] > dist[cur.x] + next.w) {
                    dist[next.x] = dist[cur.x] + next.w;
                    pq.offer(new Node(next.x, dist[next.x]));
                }
            }
        }
    }

    static class Node {
        int x;
        int w;

        public Node(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }
}