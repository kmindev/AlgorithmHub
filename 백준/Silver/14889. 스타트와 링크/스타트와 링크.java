import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int MIN = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        comb(visited, 0, 0);

        System.out.println(MIN);
    }

    static void comb(boolean[] visited, int start, int depth) {
        if (depth == N / 2) {
            diff();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(visited, i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void diff() {
        int startSum = 0;
        int linkSum = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startSum += map[i][j];
                    startSum += map[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkSum += map[i][j];
                    linkSum += map[j][i];
                }
            }
        }
        int diff = Math.abs(startSum - linkSum);
        MIN = Math.min(MIN, diff);
    }
}