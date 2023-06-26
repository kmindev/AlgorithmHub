import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N개의 동전의 가치
        int K = sc.nextInt(); // 동전으로 만드려고 하는 가치(합)
        int[] coinType = new int[N];
        for (int i = 0; i < N; i++) {
            coinType[i] = sc.nextInt();
        }

        int result = 0;

        for (int i = N - 1; i >= 0; i--) { // 동전의 가치가 큰 것 시작
            if (K >= coinType[i]) { // 구하려는 가치가 현재의 가치보다 크면 현재의 동전가치를 구성할 수 있음.
                result += (K / coinType[i]);
                K %= coinType[i];
            }
        }

        System.out.println(result);

    }
}