import java.util.Arrays;
import java.util.Scanner;
// 회문 검사(배열 비교)
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			String word = sc.next();
			boolean isEquals = true;
			
			for(int i=0; i<word.length(); i++) {
				
		
				
				if(word.charAt(i)!=word.charAt(word.length()-1-i)) {
					isEquals = false;
					break;
				}
			}
			
			// 2차원 배열 비교는 Arrays.deepEquals(a1, a2);
			if(isEquals)
				System.out.println("#"+(tc+1)+" "+1);
			else 
				System.out.println("#"+(tc+1)+" "+0);
	
		}
	}

}