import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int con = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수
        ArrayList<ArrayList<Integer>> networkMap = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < amount + 1; i++)
            networkMap.add(new ArrayList<>());

        for (int i = 0; i < con; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            networkMap.get(x).add(y);
            networkMap.get(y).add(x);
        }

        boolean[] visited = new boolean[amount + 1];

        dfs(1, visited, networkMap);
        System.out.println(COUNT);
    }

    private static void dfs(int start, boolean[] visited, ArrayList<ArrayList<Integer>> networkMap) {
        visited[start] = true;

        for(int node : networkMap.get(start)) {
            if(!visited[node]) {
                COUNT++;
                dfs(node, visited, networkMap);
            }
        }
    }
}