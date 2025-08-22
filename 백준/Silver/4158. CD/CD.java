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
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }

            int[] arr1 = new int[N];
            int[] arr2 = new int[M];
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(br.readLine());
                arr1[i] = num;
            }

            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(br.readLine());
                arr2[i] = num;
            }

            int i = 0;
            int j = 0;
            int count = 0;
            while (i != N && j != M) {
                if (arr1[i] == arr2[j]) {
                    count++;
                    i++;
                    j++;
                } else if (arr1[i] > arr2[j]) {
                    j++;
                } else {
                    i++;
                }
            }

            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }
}