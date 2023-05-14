import java.util.Scanner;

// 패턴 마디의 길이
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String s = sc.next();
			int index = 100;
			for (int i = 1; i <= s.length(); i++) {
				String a = s.substring(0, i);
				String b = s.substring(i, i + i);

				if (a.equals(b)) {
					index = i;
					break;
				}

			}

			System.out.println("#" + tc + " " + index);
		}
	}

}