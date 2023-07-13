import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] distance = new int[n - 1]; // 도시 간의 거리
        int[] oliPrice = new int[n - 1]; // 도시의 기름
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            oliPrice[i] = Integer.parseInt(st.nextToken());
        }
        int minPrice = oliPrice[0];
        int result = minPrice * distance[0];
        for (int i = 1; i < oliPrice.length; i++) {
            if (minPrice > oliPrice[i]) {
                minPrice = oliPrice[i];
            }
            result+=(minPrice * distance[i]);
        }

        System.out.println(result);

    }
}