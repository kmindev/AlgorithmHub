import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int INF = 100 * 15;
    static int N;
    static int M;
    static int R;

    static int[] item;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        item = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            arr[a][b] = Math.min(arr[a][b], l);
            arr[b][a] = Math.min(arr[b][a], l);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            int count = 0;

            for (int j = 1; j <= N; j++) {
                if (arr[i][j] <= M) {
                    count += item[j];
                }
            }

            answer = Math.max(answer, count);
        }

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }
}