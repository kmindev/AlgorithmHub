import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[3][2];
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            xMap.put(a, xMap.getOrDefault(a, 0) + 1);
            yMap.put(b, yMap.getOrDefault(b, 0) + 1);
        }

        int xResult = 0;
        int yResult = 0;

        for (Integer key : xMap.keySet()) {
            if (xMap.get(key) % 2 != 0) {
                xResult = key;
            }
        }

        for (Integer key : yMap.keySet()) {
            if (yMap.get(key) % 2 != 0) {
                yResult = key;
            }
        }

        System.out.println(xResult + " " + yResult);
    }
}