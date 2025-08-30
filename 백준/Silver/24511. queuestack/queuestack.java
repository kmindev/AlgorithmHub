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

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine()); // 자료구조 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] type = new int[N];
        for (int i = 0; i < N; i++) {
            type[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (type[i] == 0) {
                deque.addFirst(num);
            }
        }


        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int c = Integer.parseInt(st.nextToken());
            deque.addLast(c);
        }

        for (int i = 0; i < M; i++) {
            bw.write(deque.poll() + " ");
        }

        bw.flush();
        bw.close();
    }
}