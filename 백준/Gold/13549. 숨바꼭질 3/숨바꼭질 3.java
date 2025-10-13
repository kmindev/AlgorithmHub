import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int MAX = 100000;
    static int MIN = Integer.MAX_VALUE;
    static boolean[] visited;
    static int N, K;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX + 1];
        bfs(N, K);

        bw.write(MIN + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int start, int end) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            visited[cur.x] = true;
            if (cur.x == end) {
                MIN = Math.min(MIN, cur.time);
            }

            if (cur.x * 2 <= MAX && !visited[cur.x * 2]) {
                q.offer(new Node(cur.x * 2, cur.time));
            }

            if (cur.x + 1 <= MAX && !visited[cur.x + 1]) {
                q.offer(new Node(cur.x + 1, cur.time + 1));
            }

            if (cur.x - 1 >= 0 && !visited[cur.x - 1]) {
                q.offer(new Node(cur.x - 1, cur.time + 1));
            }
        }
    }

    static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}