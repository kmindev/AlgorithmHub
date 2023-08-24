import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 0) + 1);
        }

        int maxVal = 0;

        for (String key : map.keySet()) {
            maxVal = Math.max(maxVal, map.get(key));
        }

        List<String> list = new ArrayList<>();

        for (String key : map.keySet()) {
            if (maxVal == map.get(key)) {
                list.add(key);
            }
        }
        
        Collections.sort(list);

        System.out.println(list.get(0));
    }
}