import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int K;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        boolean result = bfs();
        bw.write(result ? "minigimbob" : "water");
        bw.flush();
        bw.close();
    }

    private static boolean bfs() {
        Queue<Stairs> q = new LinkedList<>();
        q.offer(new Stairs(0, 0));
        boolean[] visited = new boolean[N + 1];
        visited[0] = true;

        while (!q.isEmpty()) {
            Stairs cur = q.poll();

            if (cur.num == N && cur.count <= K) {
                return true;
            }

            if (cur.count > K) {
                break;
            }

            int next = cur.num + 1;
            if (next <= N && !visited[next]) {
                q.offer(new Stairs(next, cur.count + 1));
                visited[next] = true;
            }

            int jump = cur.num + cur.num / 2;
            if (jump <= N && !visited[jump]) {
                q.offer(new Stairs(jump, cur.count + 1));
                visited[jump] = true;
            }
        }
        return false;
    }

    static class Stairs {
        int num;
        int count;

        Stairs(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}