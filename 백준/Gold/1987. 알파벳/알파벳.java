import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int R;
    static int C;
    static int[][] map;
    static boolean[] alphaCheck;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        alphaCheck = new boolean[26];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j) - 'A';
            }
        }

        backtracking(0, 0, 1);
        bw.write(MAX + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void backtracking(int x, int y, int count) {
        alphaCheck[map[x][y]] = true;
        MAX = Math.max(MAX, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                continue;
            }

            if (!alphaCheck[map[nx][ny]]) {
                alphaCheck[map[nx][ny]] = true;
                backtracking(nx, ny, count + 1);
                alphaCheck[map[nx][ny]] = false;
            }
        }
    }
}