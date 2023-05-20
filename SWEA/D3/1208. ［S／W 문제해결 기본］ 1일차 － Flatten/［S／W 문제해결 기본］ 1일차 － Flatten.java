import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int dump = sc.nextInt();
			int[] box = new int[100];
			for (int i = 0; i < box.length; i++) {
				box[i] = sc.nextInt();
			}
			
			Arrays.sort(box);
			
			for(int i=0; i<dump;i++) {
				box[0]++;
				box[99]--;
				Arrays.sort(box);
			}
			System.out.println("#" + tc + " " + (box[99]-box[0]));
		}

	}

}