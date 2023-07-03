import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();
        StringTokenizer inputA = new StringTokenizer(br.readLine(), " ");
        StringTokenizer inputB = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++) {
            a.add(Integer.parseInt(inputA.nextToken()));
            b.add(Integer.parseInt(inputB.nextToken()));
        }

        Collections.sort(a);
        Collections.sort(b);
        Collections.reverse(b);

        int minSum = 0;

        for(int i=0; i<N; i++) {
            minSum += (a.get(i) * b.get(i));
        }

        System.out.println(minSum);

    }
}