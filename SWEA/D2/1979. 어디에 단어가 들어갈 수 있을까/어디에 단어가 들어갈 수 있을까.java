import java.util.Scanner;

// 퍼즐에 단어 넣기, 흰색:1 검은색:0
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int[][] puzzel = new int[N][N];
			int count = 0;
			
			for (int i = 0; i < puzzel.length; i++) {
				for (int j = 0; j < puzzel[i].length; j++) {
					puzzel[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < puzzel.length; i++) {
				int rLength = 0;
				int cLength = 0;
				for (int j = 0; j < puzzel[i].length; j++) {
					if(puzzel[i][j]==0) {
						if(rLength==K)
							count++;
						rLength = 0;
					} else {
						rLength++;
					}
					
					if(puzzel[j][i]==0) {
						if(cLength==K)
							count++;
						cLength = 0;
					} else {
						cLength++;
					}
				}
				if(rLength==K)
					count++;
				
				if(cLength==K)
					count++;
			}
			
			
			
			System.out.println("#"+(tc+1)+" "+count);;

		}
	}

}