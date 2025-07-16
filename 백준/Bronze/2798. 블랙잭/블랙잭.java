import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = getResult();
        System.out.println(result);
    }

    private static int getResult() {
        int result = Integer.MIN_VALUE;
        // 3가지 카드를 고르는 모든 경우의 수를 고려하여 M보다 작으면서 max값을 구한다.
        for (int i = 0; i < N - 2; i++) {
            if (arr[i] > M) {
                continue;
            }

            for (int j = i + 1; j < N - 1; j++) {
                if (arr[i] + arr[j] > M) {
                    continue;
                }

                for (int k = j + 1; k < N; k++) {
                    int sum = arr[i] + arr[j] + arr[k];

                    if (sum == M) { // M과 같으면 즉시 리턴
                        return sum;
                    }

                    if (sum <= M) {
                        result = Math.max(result, sum);
                    }
                }
            }
        }
        return result;
    }
}

