import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int result = 0;

        for(int num : arr) {
            int count = 0;
            for (int i = 1; i < num; i++) {
                if(num % i == 0) {
                    count++;
                }
            }
            if(count == 1) {
                result++;
            }
        }
        System.out.println(result);
    }
}