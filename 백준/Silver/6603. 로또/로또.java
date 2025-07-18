import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        output = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            if (k == 0) { // 0이 나올 때 까지 입력을 받는다.
                break;
            }

            int[] numbers = new int[k];
            for (int i = 0; i < k; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            int[] selectedNumbers = new int[6];

            Arrays.sort(numbers);
            comp(numbers, selectedNumbers, 0, 0);
            output.append("\n");
        }

        bw.write(output.toString());
        bw.flush();
    }

    private static void comp(int[] numbers, int[] selectNumbers, int start, int depth) {
        if (depth == selectNumbers.length) {
            for (int num : selectNumbers) {
                output.append(num).append(" ");
            }
            output.append("\n");
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            selectNumbers[depth] = numbers[i];
            comp(numbers, selectNumbers, i + 1, depth + 1);
        }
    }
}