import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int tc=1; tc<=T; tc++) {
            // N
            String s = sc.next();
            int n = Integer.parseInt(s);
            
            // 체크
            boolean[] chek =  new boolean[10];
            int count = 0;
            
            // 곱하는 수
            int a = 1;
            
            while(true) {
                for (int i=0; i<s.length(); i++) {
                    int num = Integer.parseInt(s.substring(i, i+1));
                    if(chek[num] == false) {
                        chek[num] = true;
                        count++;
                    }
                }                
                if(count==10)
                    break;
                a++;
                s = Integer.toString(a*n);
               
            }
            System.out.printf("#%d %s\n", tc, s);         
        }
	}
}