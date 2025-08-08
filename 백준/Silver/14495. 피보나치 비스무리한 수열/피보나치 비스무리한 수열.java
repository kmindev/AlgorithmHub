import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            if (i >= 3) {
                break;
            }
            arr[i] = 1;
        }

        for (int i = 3; i < N; i++) {
            arr[i] = arr[i - 1] + arr[i - 3];
        }

        bw.write(arr[N - 1] + "");

        bw.flush();
        bw.close();
    }
}