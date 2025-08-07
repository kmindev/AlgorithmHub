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
    static List<List<Node>> graph = new ArrayList<>();
    static int N;
    static long MAX = Long.MIN_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        visited[1] = true;
        dfs(1, 0);
        bw.write(MAX + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int target, long sum) {
        visited[target] = true;
        MAX = Math.max(MAX, sum);
        for (Node next : graph.get(target)) {
            if (visited[next.number]) {
                continue;
            }
            dfs(next.number, sum + next.distance);
        }
    }

    static class Node {
        int number;
        int distance;

        Node(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }
    }
}