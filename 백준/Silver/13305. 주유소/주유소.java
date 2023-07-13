import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] distance = new int[n - 1]; // 도시 간의 거리
        int[] oliPrice = new int[n - 1]; // 도시의 기름, 마지막 도시 기름 가격은 알 필요가 없기 때문에 저장하지 않는다.
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.parseInt(st1.nextToken());
            oliPrice[i] = Integer.parseInt(st2.nextToken());
        }

        // 오버플로우 발생으로 long 사용
        long minPrice = oliPrice[0]; 
        long result = minPrice * distance[0];

        for (int i = 1; i < oliPrice.length; i++) {
            if (minPrice > oliPrice[i]) { // 기름의 가격이 더 낮으면 최소 금액을 갱신한다.
                minPrice = oliPrice[i];
            }
            result+=(minPrice * distance[i]); // 거리 * 가격을 누적합 
        }

        System.out.println(result);

    }
}
