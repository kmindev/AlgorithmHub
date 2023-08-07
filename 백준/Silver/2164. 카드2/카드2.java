import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() != 1) {
            q.poll();

            int num = q.poll();
            q.add(num);
        }

        System.out.println(q.poll());
    }
}