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
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    static int[][] map;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                char ch = st.nextToken().charAt(0);
                if (Character.isDigit(ch)) {
                    map[i][j] = Character.getNumericValue(ch);
                } else {
                    if (ch == '+') {
                        map[i][j] = -1;
                    } else if (ch == '-') {
                        map[i][j] = -2;
                    } else if (ch == '*') {
                        map[i][j] = -3;
                    }
                }
            }
        }

        visited = new boolean[N][N];
        dfs(0, 0, map[0][0]);

        bw.write(MAX + " " + MIN);
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, int sum) {
        if (x == N - 1 && y == N - 1) {
            MAX = Math.max(MAX, sum);
            MIN = Math.min(MIN, sum);
            return;
        }
        visited[x][y] = true;

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                continue;
            }

            if (map[x][y] == -1) {
                dfs(nx, ny, sum + map[nx][ny]);
            } else if (map[x][y] == -2) {
                dfs(nx, ny, sum - map[nx][ny]);
            } else if (map[x][y] == -3) {
                dfs(nx, ny, sum * map[nx][ny]);
            } else {
                dfs(nx, ny, sum);
            }
        }
        visited[x][y] = false;
    }

}
