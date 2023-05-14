import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			int N = sc.nextInt();
			int sum = 0;
			
			for(int i=1; i<=N; i++) {
				if(i%2 == 0)
					sum-=i;
				else
					sum+=i;
			}
			
			System.out.println("#"+(tc+1)+" "+sum);
		}
	}

}