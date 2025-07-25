import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int S;
    static int COUNT;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            comb(new int[i], 0, 0);
        }

        System.out.println(COUNT);
    }

    static void comb(int[] selectedNumbers, int start, int depth) {
        if (depth == selectedNumbers.length) {
            int sum = 0;
            for (int num : selectedNumbers) {
                sum += num;
            }

            if (sum == S) {
                COUNT++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            selectedNumbers[depth] = numbers[i];
            comb(selectedNumbers, i + 1, depth + 1);
        }
    }
}