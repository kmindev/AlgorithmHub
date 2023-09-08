import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        while (n-- > 0) {
            pq.offer(Long.parseLong(br.readLine()));
        }

        long sum = 0;

        while (pq.size() > 1) {
            long num1 = pq.poll();
            long num2 = pq.poll();

            sum += num1 + num2;

            pq.offer(num1 + num2);
        }

        System.out.println(sum);
    }
}