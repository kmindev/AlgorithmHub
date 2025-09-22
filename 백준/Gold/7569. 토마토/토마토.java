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

    static int N;
    static int M;
    static int H;

    static int[] dh = {-1, 1, 0, 0, 0, 0};
    static int[] dn = {0, 0, -1, 0, 1, 0};
    static int[] dm = {0, 0, 0, -1, 0, 1};
    static int[][][] boxes;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        boxes = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    boxes[i][j][k] = Integer.parseInt(st.nextToken());
                    if (boxes[i][j][k] == 1) {
                        q.offer(new Point(i, j, k));
                    }
                }
            }
        }

        bfs();
        int result = getResult();
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static int getResult() {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (boxes[i][j][k] == 0) {
                        return -1;
                    }
                    result = Math.max(result, boxes[i][j][k] - 1);
                }
            }
        }
        return result;
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 6; i++) {
                int nh = cur.h + dh[i];
                int nn = cur.n + dn[i];
                int nm = cur.m + dm[i];

                if (nh < 0 || nh >= H || nn < 0 || nn >= N || nm < 0 || nm >= M || boxes[nh][nn][nm] != 0) {
                    continue;
                }

                boxes[nh][nn][nm] = boxes[cur.h][cur.n][cur.m] + 1;
                q.offer(new Point(nh, nn, nm));
            }
        }
    }

    static class Point {
        int h;
        int n;
        int m;

        public Point(int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }
    }
}