import java.util.Scanner;

// 건초더미
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int sum = 0;
			int avg = 0; 
			int count = 0;
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				sum+=arr[i];
			}
			
			avg = sum/arr.length;
			
			for(int i=0; i<N; i++) {
				if(arr[i]>avg)
					count+=arr[i]-avg;
			}
			System.out.println("#"+tc+" "+count);
			
		}

	}

}