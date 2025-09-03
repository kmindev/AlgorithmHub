import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    dq.offer(num);
                    break;
                case "pop":
                    Integer popNum = dq.poll();
                    if (popNum == null) {
                        bw.write("-1\n");
                    } else {
                        bw.write(popNum + "\n");
                    }
                    break;
                case "size":
                    bw.write(dq.size() + "\n");
                    break;
                case "empty":
                    bw.write(dq.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    Integer frontNum = dq.peekFirst();
                    if (frontNum == null) {
                        bw.write("-1\n");
                    } else {
                        bw.write(frontNum + "\n");
                    }
                    break;
                case "back":
                    Integer backNum = dq.peekLast();
                    if (backNum == null) {
                        bw.write("-1\n");
                    } else {
                        bw.write(backNum + "\n");
                    }
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}