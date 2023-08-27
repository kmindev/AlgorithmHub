import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(graph, visited, 1);

        System.out.println(answer);
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int node) {
        answer++;
        visited[node] = true;

        for (int i = 0; i < graph.get(node).size(); i++) {
            if(!visited[graph.get(node).get(i)]) {
                visited[graph.get(node).get(i)] = true;
                dfs(graph, visited, graph.get(node).get(i));
            }
        }
    }
}