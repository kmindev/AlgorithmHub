import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int M;

    static List<List<Integer>> networks = new ArrayList<>();
    static int COUNT = 0; // 1번 컴퓨터는 제외

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            networks.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            networks.get(x).add(y);
            networks.get(y).add(x);
        }

        boolean[] visited = new boolean[N + 1];
        dfs(visited, 1);

        bw.write(COUNT + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(boolean[] visited, int num) {
        visited[num] = true;
        for (int next : networks.get(num)) {
            if (!visited[next]) {
                COUNT++;
                dfs(visited, next);
            }
        }
    }
}