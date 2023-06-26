import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> p = new ArrayList<>();
        int result = 0;
        int answer = 0;

        for(int i=0; i<N; i++) {
            p.add(sc.nextInt());
        }

        Collections.sort(p);

        for(int t : p) {
            result+=t;
            answer+=result;
        }
        System.out.println(answer);

    }
}