import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N개의 동전의 가치
        int K = sc.nextInt(); // 동전으로 만드려고 하는 가치(합)
        ArrayList<Integer> coinType = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            coinType.add(sc.nextInt());
        }

        Collections.reverse(coinType);

        int result = 0;

        while (K > 0) {
            for (int coinValue : coinType) {
                if (K / coinValue > 0) {
                    result++;
                    K -= coinValue;
                    break;
                }
            }
        }

        System.out.println(result);

    }
}