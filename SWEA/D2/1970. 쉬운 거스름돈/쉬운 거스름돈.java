import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[] m = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
		for(int tc=0; tc<T; tc++) {
			int money = sc.nextInt();
			int[] change = new int[8];
			
			System.out.println("#"+(tc+1));
			for(int i=0; i<m.length; i++) {
				if(money/m[i]>0) {
					change[i] = money/m[i];
					money%= m[i];
				}
				System.out.print(change[i]+" ");
			}
	
			System.out.println();
		}
	}
}