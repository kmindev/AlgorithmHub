import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    static class Node {
        Node prev;
        Node next;
        boolean removed;

        // 이전 노드로 이동
        public Node moveUp(int movement) {
            Node temp = this;
            for (int i = 0; i < movement; i++) {
                temp = temp.prev;
            }
            return temp;
        }

        // 다음 노드로 이동
        public Node moveDown(int movement) {
            Node temp = this;
            for (int i = 0; i < movement; i++) {
                temp = temp.next;
            }
            return temp;
        }

        // 삭제(이전, 다음 노드를 서로 연결해준다.)
        public Node remove() {
            // 이전, 다음 노드를 서로 연결해준다.
            this.removed = true;

            // 헤드 노드
            if (this.prev == null) {
                this.next.prev = null;
                return this.next;
            }

            // 꼬리 노드
            if (this.next == null) {
                this.prev.next = null;
                return this.prev;
            }

            this.prev.next = this.next;
            this.next.prev = this.prev;
            return this.next;
        }

        // 복구
        public void reStore() {
            this.removed = false;
            if (this.prev != null) {
                this.prev.next = this;
            }

            if (this.next != null) {
                this.next.prev = this;
            }
        }
    }

    public String solution(int n, int k, String[] cmds) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            if (i == 0) {
                continue;
            }
            // 노드 연결
            nodes[i - 1].next = nodes[i];
            nodes[i].prev = nodes[i - 1];
        }

        Stack<Node> history = new Stack<>();
        Node current = nodes[k];
        for (String cmd : cmds) {
            StringTokenizer st = new StringTokenizer(cmd);
            String command = st.nextToken();

            if (command.equals("U")) { // 위로 이동
                int movement = Integer.parseInt(st.nextToken());
                current = current.moveUp(movement);
            } else if (command.equals("D")) { // 아래로 이동
                int movement = Integer.parseInt(st.nextToken());
                current = current.moveDown(movement);
            } else if (command.equals("C")) { // 삭제
                history.push(current);
                current = current.remove();
            } else if (command.equals("Z")) {  // 복구
                Node target = history.pop();
                target.reStore();
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (nodes[i].removed) {
                answer.append("X");
            } else {
                answer.append("O");
            }
        }
        return answer.toString();
    }
}