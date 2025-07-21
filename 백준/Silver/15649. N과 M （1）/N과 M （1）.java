import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        for (int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }

        boolean[] visited = new boolean[N];
        int[] selectedNumber = new int[M];
        back(visited, selectedNumber, 0);

        bw.write(out.toString());
        bw.flush();
    }

    private static void back(boolean[] visited, int[] selectedNumber, int depth) {
        if (depth == selectedNumber.length) {
            for (int num : selectedNumber) {
                out.append(num).append(" ");
            }
            out.append("\n");
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selectedNumber[depth] = numbers[i];
                back(visited, selectedNumber, depth + 1);
                visited[i] = false;
            }
        }
    }
}