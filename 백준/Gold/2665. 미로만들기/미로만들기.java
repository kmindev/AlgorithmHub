import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int answer = bfs(0, 0);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new PriorityQueue<>();
        q.offer(new Node(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == N - 1 && cur.y == N - 1) {
                return cur.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    q.offer(new Node(nx, ny, cur.count + 1));
                    visited[nx][ny] = true;
                } else if (map[nx][ny] == 1) {
                    q.offer(new Node(nx, ny, cur.count));
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }

    static class Node implements Comparable<Node> {
        int x, y, count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }
}