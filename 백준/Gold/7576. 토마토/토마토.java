import java.util.*;
import java.io.*;

class Main {
    private static int m;
    private static int n;
    private static int[][] map;
    private static Deque<Node> q = new ArrayDeque<>();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.valueOf(st.nextToken());
        n = Integer.valueOf(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());

                if (map[i][j] == 1) {
                    q.offer(new Node(i, j));
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        // bfs
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1)
                    continue;

                if (map[nx][ny] == 0) {
                    q.offer(new Node(nx, ny));
                    map[nx][ny] = map[x][y] + 1;
                }
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (map[i][j] == 0) // 익지 않은 토마토가 있으면
                    return -1;
                
                result = Math.max(result, map[i][j]); // 최대 일 수를 구한다.
            }
        }

        return result - 1; // 최대 일 수 - 1 
    }


    private static class Node {
        int x;
        int y;

        private Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}