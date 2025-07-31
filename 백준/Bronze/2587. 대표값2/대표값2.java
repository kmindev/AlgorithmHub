import java.util.*;
import java.io.*;

public class Main{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>(); 
        int sum = 0;
        for(int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            list.add(num);
        }
        
        Collections.sort(list);
        
        System.out.println(sum / list.size());
        System.out.println(list.get(list.size() / 2));
    }
}