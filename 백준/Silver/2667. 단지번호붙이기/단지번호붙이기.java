import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int result = 0;
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    result++;
                    int count = bfs(i, j);
                    counts.add(count);
                }
            }
        }
        
        Collections.sort(counts);
        bw.write(result + "\n");
        for (int count : counts) {
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        map[x][y] = 2; // 방문 처리
        int count = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 1) {
                    continue;
                }
                map[nx][ny] = 2;
                q.offer(new Point(nx, ny));
            }
        }
        return count;
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