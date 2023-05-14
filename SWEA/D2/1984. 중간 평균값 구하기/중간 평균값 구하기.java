import java.util.Scanner;

// 중간 평균값 구하기
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			int[] arr = new int[10];
			int sum = 0;
			float avg = 0.0f; 
			int max = 0;
			int min = 10000;
			
			for(int i=0; i<arr.length; i++) {
				arr[i] = sc.nextInt();
				max = Math.max(max, arr[i]);
				min = Math.min(min, arr[i]);
				
				sum+=arr[i];
			}
			
			sum = sum - max - min; 
			
			avg = (float) (sum/8.0);
			System.out.println("#"+(tc+1)+" "+Math.round(avg));
		}
	}

}
