import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static char[][] painting;
    static int N;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        painting = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                painting[i][j] = input.charAt(j);
            }
        }

        // 일반인
        visited = new boolean[N][N];
        int count1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count1++;
                    bfs(i, j, true);
                }
            }
        }

        // 적록색약
        visited = new boolean[N][N];
        int count2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count2++;
                    bfs(i, j, false);
                }
            }
        }

        bw.write(count1 + " " + count2);
        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y, boolean ordinary) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                    continue;
                }

                if (painting[nx][ny] == painting[cur.x][cur.y]) {
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    continue;
                }

                if (!ordinary) {
                    char curColor = painting[cur.x][cur.y];
                    char nextColor = painting[nx][ny];
                    if (curColor == 'R' || curColor == 'G') {
                        if (nextColor == 'R' || nextColor == 'G') {
                            q.offer(new Point(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}