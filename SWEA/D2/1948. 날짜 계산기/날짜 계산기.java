import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int tc=1; tc<=T; tc++) {
            int before_m = sc.nextInt()-1; // 월
            int before_d = sc.nextInt(); // 일
            int now_m = sc.nextInt()-1; // 월
            int now_d = sc.nextInt(); // 일
            int sum1 = 0; // 전
            int sum2 = 0; // 후
            int result = 0;
            
            for (int i=0; i<before_m; i++) {
                sum1+=month[i];            
            }
            for (int i=0; i<now_m; i++) {
                sum2+=month[i];            
            }
            
            sum1+=before_d;
            sum2+=now_d;
            
            result = sum2-sum1+1;
            
            System.out.printf("#%d %d\n", tc, result);
             
            
        }
	}
}