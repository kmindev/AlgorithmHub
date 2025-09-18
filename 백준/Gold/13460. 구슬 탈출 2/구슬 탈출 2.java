import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 북, 동, 남, 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static int M;
    static char[][] map;
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        int result = bfs(rx, ry, bx, by);
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static int bfs(int rx, int ry, int bx, int by) {
        visited = new boolean[N][M][N][M];
        Queue<State> q = new LinkedList<>();
        q.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.depth >= 10) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                MoveResult r = move(cur.rx, cur.ry, i);
                MoveResult b = move(cur.bx, cur.by, i);

                // 파란 구슬이 먼저 빠지면 실패
                if (b.inHole) {
                    continue;
                }

                // 빨간 구슬만 빠지면 성공
                if (r.inHole) {
                    return cur.depth + 1;
                }

                // 같은 위치면 더 많이 이동한 쪽을 한 칸 뒤로
                if (r.x == b.x && r.y == b.y) {
                    if (r.dist > b.dist) {
                        r.x -= dx[i];
                        r.y -= dy[i];
                    } else {
                        b.x -= dx[i];
                        b.y -= dy[i];
                    }
                }

                if (!visited[r.x][r.y][b.x][b.y]) {
                    visited[r.x][r.y][b.x][b.y] = true;
                    q.offer(new State(r.x, r.y, b.x, b.y, cur.depth + 1));
                }
            }
        }
        return -1;
    }

    private static MoveResult move(int x, int y, int dir) {
        int dist = 0;
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (map[nx][ny] == '#') {
                break;
            }
            x = nx;
            y = ny;
            dist++;
            if (map[x][y] == 'O') {
                return new MoveResult(x, y, dist, true);
            }
        }
        return new MoveResult(x, y, dist, false);
    }

    static class State {
        int rx, ry, bx, by, depth;

        State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    static class MoveResult {
        int x;
        int y;
        int dist;
        boolean inHole;

        MoveResult(int x, int y, int dist, boolean inHole) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.inHole = inHole;
        }
    }
}