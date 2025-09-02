import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] nums;
    static int x;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());

        Arrays.sort(nums);
        int result = toPoint(0, n - 1);
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static int toPoint(int start, int end) {
        int result = 0;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == x) {
                result++;
                start++;
                end--;
            } else if (sum > x) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }
}