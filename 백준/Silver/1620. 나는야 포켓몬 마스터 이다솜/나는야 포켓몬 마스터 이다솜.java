import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            map.put(input, i);
            list.add(input);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            try {
                int num = Integer.parseInt(question);
                sb.append(list.get(num - 1)).append("\n");
            } catch (Exception e) {
                sb.append(map.get(question)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}