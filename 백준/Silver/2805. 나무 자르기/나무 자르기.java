import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        int result = binarySearch(0, max, arr, M);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static int binarySearch(int left, int right, int[] arr, int m) {
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for (int len : arr) {
                if (len > mid) {
                    sum += (len - mid);
                }
            }

            if (sum >= m) {
                // 충분히 가져갈 수 있다 → 높이를 더 높여도 된다
                result = mid;
                left = mid + 1;
            } else {
                // 너무 적게 잘랐다 → 높이를 낮춰야 한다
                right = mid - 1;
            }
        }
        return result;
    }
}
