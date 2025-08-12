import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] dx = {-1, -1, 1, 0, 0, -1, 1, 1};
    static int[] dy = {-1, 0, -1, -1, 1, 1, 0, 1};

    public static void main(String[] args) throws IOException {

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) { // 땅이면서 방문하지 않았다면 dfs
                        dfs(map, i, j);
                        result++;
                    }
                }
            }

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int[][] map, int x, int y) {
        map[x][y] = 2; // 방문 처리
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length) { // 범위에 벗어남
                continue;
            }

            if (map[nx][ny] != 1) { // 땅이 아니거나 이미 방문한 곳이면
                continue;
            }

            dfs(map, nx, ny);
        }
    }
}