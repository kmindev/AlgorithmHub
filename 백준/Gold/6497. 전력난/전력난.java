import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int distance;

        Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 집의 수
            int n = Integer.parseInt(st.nextToken()); // 길의 수
            if (m == 0 && n == 0) {
                break;
            }

            List<Edge> edges = new ArrayList<>();
            int cost = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                cost += z;
                edges.add(new Edge(x, y, z));
            }

            Collections.sort(edges);

            int[] parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }
            int minCost = kruskal(edges, parent);
            bw.write(cost - minCost + "\n");
        }

        bw.flush();
        br.close();
    }

    static int kruskal(List<Edge> edges, int[] parent) {
        int cost = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if (find(parent, edge.start) != find(parent, edge.end)) {
                cost += edge.distance;
                union(parent, edge.start, edge.end);
            }
        }
        return cost;
    }

    private static void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return find(parent, parent[x]);
        }
    }
}