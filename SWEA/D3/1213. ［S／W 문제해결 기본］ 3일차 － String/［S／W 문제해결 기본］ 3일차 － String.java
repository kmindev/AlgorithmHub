import java.util.Scanner;

// 긴 문자열에서 특정 문자열 개수 찾아내기
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int t = sc.nextInt();
			String shortStr = sc.next();
			String longStr = sc.next();
			
			int count=0;
			for(int i=0; i<longStr.length()-shortStr.length()+1; i++) {
				if(shortStr.equals(longStr.substring(i, shortStr.length()+i)))
					count++;
			}
			
			System.out.println("#"+tc+" "+count);
		}
	}

}