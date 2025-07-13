import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int r, c, d; // 로봇의 초기 위치(r, c)와 방향(d)
    static int[][] map;
    // 북0, 동1, 남2, 서3
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(clean());
    }

    private static int clean() {
        int count = 0;

        while (true) {
            // 1. 현재 칸이 아직 청소되지 않았다면 청소
            if (map[r][c] == 0) {
                map[r][c] = 2;
                count++;
            }
            boolean moved = false;

            // 2. 4방향 탐색 (왼쪽부터 시계 방향)
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 방향을 왼쪽으로 회전
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    moved = true;
                    break;
                }
            }

            if (moved) {
                continue; // 이동했으면 다시 청소 루프
            }

            // 3. 네 방향 모두 청소 또는 벽이면, 후진 시도
            int backDir = (d + 2) % 4;
            int br = r + dr[backDir];
            int bc = c + dc[backDir];
            if (br < 0 || br >= n || bc < 0 || bc >= m || map[br][bc] == 1) {
                break; // 후진도 불가하면 종료
            }
            // 후진만 수행 (방향은 유지)
            r = br;
            c = bc;
        }
        return count;
    }
}
