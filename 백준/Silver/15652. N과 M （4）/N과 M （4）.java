import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder out;
    static int N;
    static int M;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }
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

        for (int i = start; i < N; i++) {
            selectedNumbers[depth] = numbers[i];
            back(selectedNumbers, i, depth + 1);
        }
    }
}