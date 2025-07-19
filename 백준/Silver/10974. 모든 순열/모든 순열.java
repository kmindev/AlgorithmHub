import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static StringBuilder out;
    static int N;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        out = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }

        boolean[] visited = new boolean[N];
        int[] permutation = new int[N];
        dfs(visited, permutation, 0);

        bw.write(out.toString());
        bw.flush();
    }

    static void dfs(boolean[] visited, int[] permutation, int depth) {
        if (depth == visited.length) {
            for (int num : permutation) {
                out.append(num).append(" ");
            }
            out.append("\n");
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation[depth] = numbers[i];
                dfs(visited, permutation, depth + 1);
                visited[i] = false;
            }
        }
    }
}