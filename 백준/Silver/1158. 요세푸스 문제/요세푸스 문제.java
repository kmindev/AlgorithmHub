import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> numbers = new ArrayDeque<>();
        int count = 1;

        for (int i = 1; i <= N; i++)
            numbers.offer(i);

        System.out.print("<");
        while (numbers.size() != 1) { // 제거한 번호가 N이랑 같으면 모두 제거한거기 때문에 종료
            if (count % K == 0) { // k번쨰 일 때 제거한다.
                System.out.print(numbers.poll() + ", ");
            } else { // 원 모양이기 때문에 삭제 -> 추가
                numbers.offerLast(numbers.poll());
            }
            count++;
        }
        System.out.print(numbers.remove() + ">");
    }
}