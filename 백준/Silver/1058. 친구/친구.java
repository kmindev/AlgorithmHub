import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int INF = 987654321;

    static int N;
    static int[][] check;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        check = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    check[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                if (input[j].equals("Y")) {
                    check[i][j] = 1;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    check[i][j] = Math.min(check[i][j], check[i][k] + check[k][j]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (check[j][i] <= 2) {
                    count++;
                }
            }
            answer = Math.max(count, answer);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}