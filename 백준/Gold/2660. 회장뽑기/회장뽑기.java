import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int INF = 987654321;

    static int N;
    static int[][] check;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        check = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    check[i][j] = INF;
                }
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) {
                break;
            }
            check[a][b] = 1;
            check[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    check[i][j] = Math.min(check[i][j], check[i][k] + check[k][j]);
                }
            }
        }

        int minScore = N;
        int[] scores = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int score = 0;
            for (int j = 1; j <= N; j++) {
                if (check[i][j] != INF) {
                    score = Math.max(score, check[i][j]);
                }
            }
            scores[i] = score;
            minScore = Math.min(minScore, score);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (scores[i] == minScore) {
                count++;
            }
        }

        String title = minScore + " " + count + "\n";
        StringBuilder body = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (scores[i] == minScore) {
                body.append(i).append(" ");
            }
        }
        bw.write(title);
        bw.write(body.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}