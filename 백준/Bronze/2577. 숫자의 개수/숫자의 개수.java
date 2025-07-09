import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int m = a * b * c;
        int[] result = new int[10];

        while(m > 0) {
            int tmp = m % 10;
            result[tmp]++;
            m /= 10;
        }

        for(int res : result) {
            System.out.println(res);
        }
    }
}