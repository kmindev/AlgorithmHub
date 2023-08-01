import java.util.*;
import java.io.*;

class Main {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int result = 0;
        check = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                result++;
                dfs(i);
            }
        }
        
        System.out.println(result);
    }

    private static void dfs(int node) {
        check[node] = true;

        for (int i = 0; i < graph.get(node).size(); i++) {
            int nNode = graph.get(node).get(i);
            if (!check[nNode]) {
                dfs(nNode);
            }
        }
    }
}