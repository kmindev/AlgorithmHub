import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int sum = 0;
        int end = 0;
        int len = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int start = 0; start <= n - k; start++) {
            while (end < n && len < k) {
                sum += arr[end];
                end++;
                len++;
            }
            maxSum = Math.max(maxSum, sum);
            sum -= arr[start];
            len--;
        }

        System.out.println(maxSum);
    }
}