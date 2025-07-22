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
    static StringBuilder out = new StringBuilder();
    static int N;
    static int M;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int[] selectedNumbers = new int[M];
        back(selectedNumbers, 0, 0);
        bw.write(out.toString());
        bw.flush();
    }

    private static void back(int[] selectedNumbers, int start, int depth) {
        if (depth == M) {
            for (int num : selectedNumbers) {
                out.append(num).append(" ");
            }
            out.append("\n");
            return;
        }
        int before = 0;
        for (int i = start; i < N; i++) {
            int num = numbers[i];
            if (num == before) {
                continue;
            }
            selectedNumbers[depth] = num;
            back(selectedNumbers, i + 1, depth + 1);
            before = num;
        }
    }
}