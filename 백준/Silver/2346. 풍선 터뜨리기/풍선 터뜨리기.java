import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node {
        int num;
        int x;
        Node next;
        Node prev;

        Node move(int x) {
            Node cur = this;
            if (x > 0) {
                for (int i = 0; i < x; i++) {
                    cur = cur.next;
                }
            } else {
                for (int i = x; i < 0; i++) {
                    cur = cur.prev;
                }
            }
            return cur;
        }

        public void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            Node node = new Node();
            node.num = i + 1;
            node.x = Integer.parseInt(st.nextToken());
            nodes[i] = node;

            if (i == 0) {
                continue;
            }
            nodes[i - 1].next = node;
            nodes[i].prev = nodes[i - 1];
        }

        // 원형 연결리스트
        nodes[0].prev = nodes[N - 1];
        nodes[N - 1].next = nodes[0];

        Node cur = nodes[0];
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            answer.append(cur.num).append(" ");

            // 현재 노드 삭제
            cur.remove();

            int step = cur.x;

            if (i == N - 1) {
                break;
            }

            cur = cur.move(step);
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }

}
