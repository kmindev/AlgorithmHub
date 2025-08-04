import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[N + 1];
        isPrime[0] = true;
        isPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= N; j += i) {
                isPrime[j] = true;
            }
        }

        StringBuilder out = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!isPrime[i]) {
                out.append(i).append("\n");
            }
        }
        System.out.println(out);
    }
}
