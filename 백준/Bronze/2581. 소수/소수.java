import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[M + 1];
        isPrime[0] = true;
        isPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(M); i++) {
            if (isPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= M; j += i) {
                isPrime[j] = true;
            }
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = N; i <= M; i++) {
            if (!isPrime[i]) {
                sum += i;
                min = Math.min(min, i);
            }
        }

        if (sum == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sum);
        System.out.println(min);
    }
}