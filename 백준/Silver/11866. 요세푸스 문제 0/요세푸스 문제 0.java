import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();

        StringBuilder result = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        result.append("<");

        while (q.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                int num = q.poll();
                q.offer(num);
            }

            result.append(q.poll() + ", ");
        }
        result.append(q.poll() + ">");
        System.out.println(result);
    }
}