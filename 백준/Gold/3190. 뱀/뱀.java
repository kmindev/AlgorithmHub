import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N; // 보드 크기
    static int K; // 사과 개수
    static int L; // 뱀의 방향 변환 횟수

    // 북(0), 동(1), 남(2), 서(3)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int d = 1; // 초기 동쪽

    static int[][] BOARD;
    static Map<Integer, Character> direction = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        BOARD = new int[N][N];
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            BOARD[x][y] = 1; // 사과
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            direction.put(x, c);
        }

        int result = solve();

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static int solve() {
        int time = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        BOARD[0][0] = 2;
        // 머리 위치
        int headX = 0;
        int headY = 0;

        while (true) {
            int nx = headX + dx[d];
            int ny = headY + dy[d];
            time++;

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || BOARD[nx][ny] == 2) { // 벽이거나 몸통이 부딪힐 때
                break;
            }

            Point next = new Point(nx, ny);
            if (BOARD[nx][ny] == 1) {
                BOARD[nx][ny] = 2;
                q.offer(next);
            } else if (BOARD[nx][ny] == 0) {
                Point remove = q.poll();
                BOARD[remove.x][remove.y] = 0;
                BOARD[nx][ny] = 2;
                q.offer(next);
            }

            if (direction.containsKey(time)) {
                if (direction.get(time) == 'L') {
                    d = (d + 3) % 4;  // 왼쪽
                } else if (direction.get(time) == 'D') {
                    d = (d + 1) % 4;  // 오른쪽
                }
            }
            headX = nx;
            headY = ny;
        }
        return time;
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