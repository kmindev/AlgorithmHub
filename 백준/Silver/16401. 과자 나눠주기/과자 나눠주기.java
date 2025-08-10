import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int M;
    static int N;
    static long MAX = Long.MIN_VALUE;
    static Long[] len;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        len = new Long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            len[i] = Long.parseLong(st.nextToken());
            MAX = Math.max(MAX, len[i]);
        }

        long result = 0;

        long left = 1;
        long right = MAX;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (long l : len) {
                count += l / mid;
            }

            if (count >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
   
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}