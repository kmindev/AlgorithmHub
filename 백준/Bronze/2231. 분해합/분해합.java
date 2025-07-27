import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            int sum = i;
            int currentNum = i;
            while (currentNum > 0) {
                sum += (currentNum % 10);
                currentNum /= 10;
            }
            if (sum == N) {
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println(0);
    }
}