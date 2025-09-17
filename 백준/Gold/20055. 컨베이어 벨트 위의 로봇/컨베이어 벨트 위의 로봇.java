import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int K;
    static Belt[] belts; // 내구도

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belts = new Belt[N * 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            belts[i] = new Belt(Integer.parseInt(st.nextToken()), false);
        }

        int result = solve();
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static int solve() {
        int step = 0;
        while (true) {
            step++;
            rotate();
            move();
            add();

            // 내구도 체크
            int zeroCount = getZeroCount();
            if (zeroCount >= K) {
                break;
            }
        }
        return step;
    }


    private static int getZeroCount() {
        int count = 0;
        for (int i = 0; i < belts.length; i++) {
            if (belts[i].durability == 0) {
                count++;
            }
        }
        return count;
    }

    // 새 로봇 올리기(0번 칸의 내구도가 1이상이면 올리고, 내구도 1 감소)
    private static void add() {
        if (belts[0].durability > 0 && !belts[0].hasRobot) {
            belts[0].hasRobot = true;
            belts[0].durability--;
        }
    }

    // 벨트 회전
    private static void rotate() {
        Belt last = belts[belts.length - 1];
        for (int i = belts.length - 1; i > 0; i--) {
            belts[i] = belts[i - 1];
        }
        belts[0] = last;
        // 로봇도 같이 회전하므로, 내리는 위치(N - 1)에 로봇이 있으면 내림
        if (belts[N - 1].hasRobot) {
            belts[N - 1].hasRobot = false;
        }
    }

    private static void move() {
        for (int i = N - 2; i >= 0; i--) {
            if (belts[i].hasRobot && !belts[i + 1].hasRobot && belts[i + 1].durability > 0) {
                belts[i].hasRobot = false;
                belts[i + 1].hasRobot = true;
                belts[i + 1].durability--;
            }
        }
        // 내리는 위치면 로봇이 내림
        if (belts[N - 1].hasRobot) {
            belts[N - 1].hasRobot = false;
        }
    }


    static class Belt {
        int durability; // 내구도
        boolean hasRobot; // 로봇이 있는지

        public Belt(int durability, boolean hasRobot) {
            this.durability = durability;
            this.hasRobot = hasRobot;
        }
    }
}