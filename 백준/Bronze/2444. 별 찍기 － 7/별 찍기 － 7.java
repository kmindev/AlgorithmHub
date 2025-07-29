import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder out = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            for (int j = N - i; j > 0; j--) {
                out.append(" ");
            }

            for (int j = 0; j < i * 2 - 1; j++) {
                out.append("*");
            }
            out.append("\n");
        }

        for (int i = N - 1; i > 0; i--) {
            for (int j = N - 1; j >= i; j--) {
                out.append(" ");
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                out.append("*");
            }
            out.append("\n");
        }

        System.out.println(out);
    }
}