import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int s = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;
        int len = 0;

        for (int i = 0; i < arr.length; i++) {
            while (sum < s && j < arr.length) {
                sum += arr[j];
                j++;
                len++;
            }

            if (sum >= s) {
                minLen = Math.min(minLen, len);
            }

            sum -= arr[i];
            len--;
        }
        if (minLen == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(minLen);
    }
}