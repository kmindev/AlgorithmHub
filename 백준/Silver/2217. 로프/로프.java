import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        Collections.reverse(list);
        int max = 0;

        for (int i = 0; i < list.size(); i++) {
            int j = 0;
            int w = 0;
            for (j = 0; j <= i; j++)
                w += list.get(i);

            max = Math.max(max, w);
        }

        System.out.println(max);


    }
}