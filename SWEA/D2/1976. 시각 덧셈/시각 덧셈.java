import java.util.Scanner;

// 시간 덧셈
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in); 
		int T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			int b_hour = sc.nextInt();
			int b_min = sc.nextInt();
			int a_hour = sc.nextInt();
			int a_min = sc.nextInt();
			
			int hour = b_hour + a_hour;
			int min = b_min + a_min;
			
			if(min>59) {
				hour++;
				min-=60;
			}
			
			if(hour>12) {
				hour-=12;
			}
			
			System.out.printf("#%d %d %d", tc+1, hour, min);
			System.out.println();
			
		}
	}

}