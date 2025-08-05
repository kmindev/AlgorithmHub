import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int MAX_HEIGHT = Integer.MIN_VALUE;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                MAX_HEIGHT = Math.max(MAX_HEIGHT, map[i][j]);
            }
        }

        int result = 0;
        for (int h = 0; h <= MAX_HEIGHT; h++) {
            boolean[][] visited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (h < map[i][j] && !visited[i][j]) {
                        dfs(visited, i, j, h);
                        count += 1;
                    }
                }
            }
            result = Math.max(result, count);
        }

        bw.write(result + " ");
        bw.flush();
        bw.close();
    }

    static void dfs(boolean[][] visited, int x, int y, int height) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) { // 범위에 벗어나면
                continue;
            }

            if (visited[nx][ny] || map[nx][ny] <= height) { // 안전지대거나 방문 x
                continue;
            }

            dfs(visited, nx, ny, height);
        }
    }

}