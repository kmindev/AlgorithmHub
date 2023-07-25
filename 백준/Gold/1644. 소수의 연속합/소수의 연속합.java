import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        ArrayList<Integer> primeList = new ArrayList<>();
        // 1. n 이하의 소수를 모두 구해서 리스트에 저장
        for (int i = 0; i <= n; i++) {
            if (isPrimeNumber(i)) {
                primeList.add(i);
            }
        }

        // 2. 리스트의 연속된 합을 구해서 n이 되는 수를 카운트해서 출력
        int sum = 0;
        int end = 0;
        int cnt = 0;

        for (int start = 0; start < primeList.size(); start++) {
            while (end < primeList.size() && sum < n) {
                sum += primeList.get(end);
                end++;
            }

            if (sum == n)
                cnt++;
            sum -= primeList.get(start);
        }

        System.out.println(cnt);
    }

    private static boolean isPrimeNumber(int num) {
        if (num == 0 || num == 1)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }
}