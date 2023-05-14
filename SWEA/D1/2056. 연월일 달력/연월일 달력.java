
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{		
        int [] days =  {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
            int n = sc.nextInt();
                   
            int y = n /10000; 
            int m = (n % 10000)/100;
            int d = n % 100;  		
            
            if ((m>0 && m<13) && (days[m-1]>=d))
                System.out.printf("#%d %04d/%02d/%02d\n", test_case+1, y, m, d);
            else 
                System.out.printf("#%d %d\n", test_case+1, -1);
		}
	}
}