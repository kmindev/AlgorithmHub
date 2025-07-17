import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 100) {
            System.out.println(N);
            return;
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (isHansu(i)) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean isHansu(int x) {
        // x는 1000이하 작으므로 1 ~ 999

        // 1000은 한수 x
        if (x == 1000) {
            return false;
        }

        // 1 ~ 99는 한수
        if (x < 100) {
            return true;
        }

        // 100 ~ 999
        int a = x % 10; // 1의 자리
        int b = (x / 10) % 10; // 10의 자리
        int c = (x / 100) % 10; // 100의 자리

        return (b - a) == (c - b);
    }
}