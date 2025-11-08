import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<Integer> nums = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums.add(num);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> sorted = nums.stream()
            .sorted((o1, o2) -> {
                if (countMap.get(o1) == countMap.get(o2)) {
                    return nums.indexOf(o1) - nums.indexOf(o2);
                }
                return countMap.get(o2) - countMap.get(o1);
            })
            .collect(Collectors.toList());

        for (int num : sorted) {
            bw.write(num + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}