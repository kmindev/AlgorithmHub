import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        int answer = bfs(0, 0);
        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);
        pq.offer(new Node(x, y, 0));
        visited[x][y] = true;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    pq.offer(new Node(nx, ny, cur.count));
                    visited[nx][ny] = true;
                } else if (map[nx][ny] == 1) {
                    pq.offer(new Node(nx, ny, cur.count + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        return 0;
    }

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}