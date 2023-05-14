import java.util.Scanner;
import java.io.FileInputStream;
// 가위는 1, 바위는 2, 보는 3으로 표현되며 A와 B가 무엇을 냈는지 입력으로 주어진다.
class Solution
{
	public static void main(String args[]) throws Exception
	{		
        Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
        int B = sc.nextInt();
        
        if((A==1 && B==3) || (A==2 && B==1) || (A==3 && B== 2))
           System.out.println('A');
        else
            System.out.println('B');
                              
	}
}