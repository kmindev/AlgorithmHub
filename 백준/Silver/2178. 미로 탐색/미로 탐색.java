import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        System.out.println(bfs(map, 0, 0));
    }

    private static int bfs(int[][] map, int x, int y) {
        Deque<Node> deque = new ArrayDeque<>();

        deque.offer(new Node(x, y));

        while (!deque.isEmpty()) {
            Node node = deque.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                // 다음 이동할 위치
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위에 벗어날 때
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[x].length)
                    continue;

                // 벽 인 경우
                if (map[nx][ny] == 0)
                    continue;

                else if (map[nx][ny] == 1) { // 벽이 아니고 지나간 적이 없을 때
                    map[nx][ny] = map[x][y] + 1; // 거리 누적
                    deque.offer(new Node(nx, ny));
                }
            }
        }

        return map[map.length - 1][map[x].length - 1];

    }

    public static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }
}