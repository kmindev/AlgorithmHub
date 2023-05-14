
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

        for(int i=0; i<str.length(); i++) {
            int n = (int)str.charAt(i) - 64;
            System.out.print(n+" ");
        }
        
	}
}