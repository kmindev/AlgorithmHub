import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int lastNum = 0;

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                String command = st.nextToken();

                if(command.equals("push")) {
                    int pushNum = Integer.parseInt(st.nextToken());
                    queue.offer(pushNum);
                    lastNum = pushNum;
                } else if (command.equals("pop")) {
                    Integer pollRes = queue.poll();
                    int res = pollRes == null ? -1 : pollRes;
                    System.out.println(res);
                } else if (command.equals("size")) {
                    System.out.println(queue.size());
                } else if (command.equals("empty")) {
                    int res = queue.isEmpty() ? 1 : 0;
                    System.out.println(res);
                } else if (command.equals("front")) {
                    Integer peekRes = queue.peek();
                    int res = peekRes == null ? -1 : peekRes;
                    System.out.println(res);
                } else if (command.equals("back")) {
                    int res = queue.isEmpty() ? -1 : lastNum;
                    System.out.println(res);
                }
            }
        }
    }
}