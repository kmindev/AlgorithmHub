import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int result = 0;
        if (N == 1) {
            result = 1;
        } else if (N == 2) {
            result = Math.min(3, (M - 1) / 2) + 1;
        } else if (N >= 3) {
            if (M < 7) {
                result = Math.min(4, M);
            } else {
                result = M - 2;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
