import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] origin = new int[N];
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }
        int[] sorted = Arrays.copyOf(origin, N);
        Arrays.sort(sorted);

        int rank = -1;
        for (int num : sorted) {
            if (!rankMap.containsKey(num)) {
                rank++;
            }
            rankMap.put(num, rank);
        }

        for (int num : origin) {
            bw.write(rankMap.get(num) + " ");
        }

        bw.flush();
        bw.close();
    }
}