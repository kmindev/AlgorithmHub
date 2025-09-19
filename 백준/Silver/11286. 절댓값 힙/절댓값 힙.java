import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int result = Math.abs(o1) - Math.abs(o2);
            if (result == 0) {
                return o1 - o2;
            }
            return result;
        });

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                Integer result = pq.poll();
                bw.write(result == null ? 0 + "\n" : result + "\n");
            } else {
                pq.offer(num);
            }
        }

        bw.flush();
        bw.close();
    }
}