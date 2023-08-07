import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            } else if (command.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            } else if (command.equals("pop_front")) {
                if (deque.isEmpty()) {
                    result.append(-1 + "\n");
                } else {
                    result.append(deque.pollFirst() + "\n");
                }
            } else if (command.equals("pop_back")) {
                if (deque.isEmpty()) {
                    result.append(-1 + "\n");
                } else {
                    result.append(deque.pollLast() + "\n");
                }
            } else if (command.equals("size")) {
                result.append(deque.size() + "\n");
            } else if (command.equals("empty")) {
                if (deque.isEmpty()) {
                    result.append(1 + "\n");
                } else {
                    result.append(0 + "\n");
                }
            } else if (command.equals("front")) {
                if (deque.isEmpty()) {
                    result.append(-1 + "\n");
                } else {
                    result.append(deque.getFirst() + "\n");
                }
            } else if (command.equals("back")) {
                if (deque.isEmpty()) {
                    result.append(-1 + "\n");
                } else {
                    result.append(deque.getLast() + "\n");
                }
            }
        }

        System.out.println(result);
    }
}