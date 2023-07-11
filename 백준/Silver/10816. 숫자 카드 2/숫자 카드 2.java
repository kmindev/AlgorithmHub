import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n[] = new int[N];
        for (int i = 0; i < N; i++)
            n[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(n);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int firstIndex = lowerBound(n, target);
            int lastIndex = upperBound(n, target);
            sb.append(lastIndex - firstIndex + " ");
        }

        System.out.println(sb);
    }

    private static int lowerBound(int[] n, int target) {
        int start = 0;
        int end = n.length;

        while (start < end) { // 처음등장하는 target을 찾는다.
            int mid = (start + end) / 2;

            if (target <= n[mid])
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }

    private static int upperBound(int[] n, int target) {
        int start = 0;
        int end = n.length;

        while (start < end) { // 마지막에 등장하는 target을 찾는다.
            int mid = (start + end) / 2;

            if (target < n[mid])  
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }
}