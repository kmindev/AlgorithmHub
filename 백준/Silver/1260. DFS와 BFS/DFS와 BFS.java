import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 노드
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (ArrayList<Integer> arr : graph)
            Collections.sort(arr);

        dfs(V, visited);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V, visited);
    }

    private static void dfs(int V, boolean[] visited) {
        visited[V] = true; // 방문처리
        System.out.print(V + " ");
        for (int node : graph.get(V)) { // 현재 노드와 연결된 다른 노드를 방문하지 않았으면 재귀적으로 방문
            if (!visited[node]) {
                dfs(node, visited);
            }
        }
    }

    private static void bfs(int V, boolean[] visited) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(V);
        visited[V] = true; // 시작 노드 방문 처리
        while (!deque.isEmpty()) { 
            int x = deque.poll(); // 큐에서 하나 뽑아서 출력
            System.out.print(x + " ");
            for (int node : graph.get(x)) { // depth 가 같은걸 탐색
                if (!visited[node]) {
                    deque.offer(node);
                    visited[node] = true;
                }
            }
        }
    }

}