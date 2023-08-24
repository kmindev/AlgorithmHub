import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxVal = 0;
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxVal = Math.max(maxVal, map.get(num));
        }

        List<Long> list = new ArrayList<>();

        for (long key : map.keySet()) {
            if (maxVal == map.get(key)) {
                list.add(key);
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}