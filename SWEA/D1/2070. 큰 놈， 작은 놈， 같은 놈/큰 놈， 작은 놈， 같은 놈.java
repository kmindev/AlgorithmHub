
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		 
		//System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            String s = "";
            if (a>b)
                s = ">";
            else if (a<b)
                s = "<";
            else
                s = "=";
            System.out.println("#"+test_case +" "+s);
		}
	}
}