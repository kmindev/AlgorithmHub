import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        int[][] map = new int[n][n];
        int count = 0;
        ArrayList<Integer> resList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    resList.add(bfs(i, j, map, 0));
                    count++;
                }
            }
        }
        Collections.sort(resList);

        System.out.println(count);
        for (int res : resList) {
            System.out.println(res);
        }
    }

    private static int bfs(int x, int y, int[][] map, int count) {
        Deque<Node> q = new ArrayDeque<>();
        q.offer(new Node(x, y));
        map[x][y] = 0;

        while (!q.isEmpty()) {
            count++;
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx > map.length - 1 || ny > map[x].length - 1 || map[nx][ny] == 0)
                    continue;

                if (map[nx][ny] == 1) {
                    q.offer(new Node(nx, ny));
                    map[nx][ny] = 0;
                }
            }
        }
        return count;
    }


    public static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }

}