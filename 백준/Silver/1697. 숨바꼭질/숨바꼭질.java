import java.util.*;
import java.io.*;

class Main {
    private static int[] check = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        System.out.println(bfs(n, k));
    }

    private static int bfs(int n, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(n);
        check[n] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();

            int[] next = {current + 1, current - 1 , current * 2}; // 이동할 수 있는 위치

            for (int i = 0; i < next.length; i++) {
                // 범위에 벗어나고, 이미 방문한적이 있는 경우
                if (next[i] < 0 || next[i] > check.length - 1 || check[next[i]] > 0)
                    continue;

                // 동생을 찾았다!
                if (next[i] == k) {
                    return check[current];
                }

                check[next[i]] = check[current] + 1; // 초를 누적
                q.offer(next[i]);
            }
        }
        return 0;
    }
}