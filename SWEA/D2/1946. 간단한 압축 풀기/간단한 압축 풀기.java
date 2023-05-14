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
            int count=0;
            System.out.println("#"+tc);
            for(int ttc=1; ttc<=N; ttc++) {
                char ci = sc.next().charAt(0);  // A~Z
                int ki = sc.nextInt(); // 1 ~ 20
                for(int i=0; i<ki; i++) {
                    System.out.print(ci);
                    count++;
                    if(count==10){
                        System.out.println();
                        count=0;
                    }
                }   
            }
            System.out.println();
        }
        
	}
}