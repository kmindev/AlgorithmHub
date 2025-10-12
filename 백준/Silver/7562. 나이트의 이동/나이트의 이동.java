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

    static int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dy = {-2, 2, -1, 1, -2, 2, -1, 1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visited = new boolean[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int nextX = Integer.parseInt(st.nextToken());
            int nextY = Integer.parseInt(st.nextToken());

            int answer = bfs(curX, curY, nextX, nextY);
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int startX, int startY, int endX, int endY) {
        if (startX == endX && startY == endY) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX, startY, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || visited[nx][ny]) {
                    continue;
                }

                q.offer(new Node(nx, ny, cur.distance + 1));
                map[nx][ny] = cur.distance + 1;
                visited[nx][ny] = true;
            }
        }

        return map[endX][endY];
    }

    static class Node {
        int x, y, distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

}