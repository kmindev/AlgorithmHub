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
        int[] n = new int[N];
        for (int i = 0; i < N; i++)
            n[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        Arrays.sort(n);

        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (Arrays.binarySearch(n, Integer.parseInt(st.nextToken())) >= 0)
                sb.append(1 + " ");
            else
                sb.append(0 + " ");
        }
        System.out.println(sb);
    }
}