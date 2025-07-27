import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int number = 666;
        int count = 0;

        while (true) {
            if (isJoungMalNumber(number)) {
                count++;
            }

            if (count == N) {
                break;
            }
            number++;
        }
        System.out.println(number);
    }

    static boolean isJoungMalNumber(int number) {
        return String.valueOf(number).contains("666");
    }
}