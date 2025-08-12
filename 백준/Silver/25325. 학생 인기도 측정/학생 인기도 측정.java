import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String name = st.nextToken();
            map.put(name, 0);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String name = st.nextToken();
                map.put(name, map.get(name) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((e1, e2) -> {
            int x = e2.getValue().compareTo(e1.getValue()); // count 내림차순
            if (x == 0) { // count가 같으면
                return e1.getKey().compareTo(e2.getKey()); // 이름 오름차순
            }
            return x;
        });

        for (Entry<String, Integer> entry : entries) {
            bw.write(entry.getKey() + " " + entry.getValue() + "\n");
        }

        bw.flush();
        bw.close();
    }

}