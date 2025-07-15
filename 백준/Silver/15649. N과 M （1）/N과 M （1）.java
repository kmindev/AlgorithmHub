import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n];
        int[] arr = new int[m];
        back(visited, arr, 0);
    }

    private static void back(boolean[] visited, int[] arr, int depth) {
        if (depth == arr.length) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                back(visited, arr, depth + 1);
                visited[i] = false;
            }
        }
    }
}