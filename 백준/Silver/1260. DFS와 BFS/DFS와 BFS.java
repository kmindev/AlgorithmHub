import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int V; // 시작 번호

    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Node(y));
            graph.get(y).add(new Node(x));
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        boolean[] visited = new boolean[N + 1];
        dfs(visited, V);

        bw.write("\n");

        visited = new boolean[N + 1];
        bfs(visited, V);

        bw.flush();
        bw.close();
    }

    static void bfs(boolean[] visited, int v) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            bw.write(cur + " ");

            for (Node next : graph.get(cur)) {
                if (!visited[next.num]) {
                    q.offer(next.num);
                    visited[next.num] = true;
                }
            }
        }
    }

    static void dfs(boolean[] visited, int cur) throws IOException {
        visited[cur] = true;
        bw.write(cur + " ");
        for (Node next : graph.get(cur)) {
            if (!visited[next.num]) {
                dfs(visited, next.num);
            }
        }
    }

    static class Node implements Comparable<Node> {
        int num;

        Node(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return this.num - o.num;
        }
    }
}
