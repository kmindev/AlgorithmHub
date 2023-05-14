import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
        for (int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            int a=0, b=0, c=0, d=0, e=0;
            while (N>1) {
                if(N%2==0) {
                    N/=2;
                    a++;
                } else if(N%3==0) {
                    N/=3;
                    b++;
                } else if(N%5==0) {
                    N/=5;
                    c++;
                } else if(N%7==0) {
                    N/=7;
                    d++;
                } else if(N%11==0) {
                    N/=11;
                    e++;
                }                
            }
            System.out.printf("#%d %d %d %d %d %d\n",  tc, a, b, c, d, e);
        }
       
	}
}