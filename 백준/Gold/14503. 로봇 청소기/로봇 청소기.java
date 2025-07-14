import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // map 크기 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 위치 정보 입력
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        // map 정보 입력
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (true) {
            // 청소
            if (map[r][c] == 0) {
                map[r][c] = 2; // 청소한 구역이면 2
                result++;
            }

            boolean moved = false;

            // 4가지 방향 탐색
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (map[nr][nc] == 0) {
                        r = nr;
                        c = nc;
                        moved = true;
                        break;
                    }
                }
            }

            if (moved) {
                continue;
            }

            // 후진
            int backDir = (d + 2) % 4;
            int backR = r + dr[backDir];
            int backC = c + dc[backDir];
            if (backR < 0 || backR >= n || backC < 0 || backC >= m || map[backR][backC] == 1) {
                break;
            }
            r = backR;
            c = backC;
        }
        System.out.println(result);
    }
}