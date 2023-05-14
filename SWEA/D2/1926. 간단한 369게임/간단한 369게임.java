import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String s = "";
		for (int i = 1; i <= N; i++) {
			String str = Integer.toString(i);
			if(str.contains("3")||str.contains("6")||str.contains("9")) {
				for(int j=0; j<str.length();j++) {
					if(str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
						System.out.print("-");
					}
				}
				System.out.print(" ");
			}
			else {
				System.out.print(i+" ");
			}
		}

		
		
	}

}