import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);

            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            }

            if (arr[0] + arr[1] <= arr[2]) {
                System.out.println("Invalid");
                continue;
            }

            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                System.out.println("Equilateral");
                continue;
            }

            if (arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[0]) {
                System.out.println("Isosceles");
                continue;
            }

            System.out.println("Scalene");
        }
    }
}