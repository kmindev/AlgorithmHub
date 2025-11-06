import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        List<Participant> participants = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int score = Integer.parseInt(br.readLine());
            participants.add(new Participant(i + 1, score));
        }

        Collections.sort(participants, Collections.reverseOrder());

        int sum = 0;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sum += participants.get(i).score;
            nums.add(participants.get(i).num);
        }

        Collections.sort(nums);

        bw.write(sum + "\n");

        for (int num : nums) {
            bw.write(num + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Participant implements Comparable<Participant> {
        int num;
        int score;

        public Participant(int num, int score) {
            this.num = num;
            this.score = score;
        }


        @Override
        public int compareTo(Participant o) {
            return this.score - o.score;
        }
    }
}