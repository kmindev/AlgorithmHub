import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 조교의 성적 매기기
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		String[] result = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
		for(int tc=0; tc<T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] score = new int[N][3];
			Double[] scoreGrade = new Double[N];
			Double stuScore = 0.0;
			String grade = null;
			int rank = -1;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<3; j++) {
					score[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<N; i++) {
				scoreGrade[i] = (Double) (score[i][0] * 0.35);
				scoreGrade[i] += (Double) (score[i][1] * 0.45);
				scoreGrade[i] += (Double) (score[i][2] * 0.20);
			}
			
			stuScore = scoreGrade[K-1];
			
			Arrays.sort(scoreGrade, Collections.reverseOrder());
			for(int i=0; i<scoreGrade.length; i++) {
				if(stuScore == scoreGrade[i])
					rank = i;
			}
			System.out.println("#"+(tc+1)+" "+result[rank/(N/10)]);
		}
		
	}

}