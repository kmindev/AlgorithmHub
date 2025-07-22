import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] numbers;
    static int[] operator = new int[4];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        back(numbers[0], 1);

        bw.write(MAX + "\n" + MIN);
        bw.flush();
    }

    static void back(int num, int depth) {
        if (depth == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] <= 0) {
                continue;
            }

            operator[i]--;
            if (i == 0) {
                back(num + numbers[depth], depth + 1);
            } else if (i == 1) {
                back(num - numbers[depth], depth + 1);
            } else if (i == 2) {
                back(num * numbers[depth], depth + 1);
            } else {
                back(num / numbers[depth], depth + 1);
            }
            operator[i]++;
        }
    }
}