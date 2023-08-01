import java.util.*;
import java.io.*;

class Main {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.valueOf(br.readLine());

        for(int tc=0; tc<t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.valueOf(st.nextToken());
            int n = Integer.valueOf(st.nextToken());
            int k = Integer.valueOf(st.nextToken());
            int count = 0;

            int[][] map = new int[m][n];

            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.valueOf(st.nextToken());
                int y = Integer.valueOf(st.nextToken());
                map[x][y] = 1;
            }

            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(map[i][j] == 1) {
                        dfs(i, j, map);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int x, int y, int[][] map) {
        if(x < 0 || y < 0 || x > map.length - 1 || y > map[x].length -1)
            return;

        if(map[x][y] == 1) {
            map[x][y] = 0;
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                dfs(nx, ny, map);
            }
        }
    }
}