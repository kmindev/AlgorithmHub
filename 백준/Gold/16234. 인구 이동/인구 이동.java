import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int L;
    static int R;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] map;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solve();
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static int solve() {
        int day = 0;
        while (true) {
            boolean[][] visited = new boolean[N][N];
            boolean moved = false;  // 하루 동안 국경이 열렸는지 체크

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(visited, i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) {
                break;
            }
            day++;
        }
        return day;
    }

    private static boolean bfs(boolean[][] visited, int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        boolean canMove = false;

        List<Point> history = new ArrayList<>();
        int sum = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            sum += map[cur.x][cur.y];
            history.add(cur);
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                Point next = new Point(nx, ny);
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                    continue;
                }

                int diff = Math.abs(map[cur.x][cur.y] - map[next.x][next.y]);
                if (diff >= L && diff <= R) {
                    q.offer(next);
                    visited[next.x][next.y] = true;
                    canMove = true;
                }
            }
        }
        int avg = sum / history.size();

        for (Point point : history) {
            map[point.x][point.y] = avg;
        }

        return canMove;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}