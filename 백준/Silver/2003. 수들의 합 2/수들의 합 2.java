import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int result = 0;

        for(int i=0; i<arr.length; i++) {
            int sum = 0;
            int j=i;

            while(sum < m && j < arr.length) {
                sum+= arr[j];
                j++;
            }

            if(sum == m)
                result++;

        }

        System.out.println(result);

    }
}