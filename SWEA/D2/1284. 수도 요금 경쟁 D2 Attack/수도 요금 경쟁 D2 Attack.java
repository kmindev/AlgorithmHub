
import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
	public static void main(String args[]) throws Exception
	{		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
// P, Q, R, S, W
		for(int test_case = 1; test_case <= T; test_case++) {
            int  P = sc.nextInt(); // A사의 1L 당 요금
            int Q = sc.nextInt(); // B사 기본 요금
            int R = sc.nextInt(); // B사의 기본 요금 기준 L
            int S = sc.nextInt(); // B사의 1L당 추가 요금
            int W = sc.nextInt(); // 사용량L
            
            int aPrice = P * W;  // A사의 총 요금
            int bPrice;  // B사의 총 요금
            
            if(W>R) { // B사에서 기본 요금 넘음
                bPrice = Q + S * (W - R);
            } else {
                bPrice = Q;
            }
            
            if(aPrice<bPrice) // B사가 더 비쌀 때
                System.out.printf("#%d %d\n", test_case, aPrice);
            else // A사가 비싸거나 같을 때
                System.out.printf("#%d %d\n", test_case, bPrice);
		}
	}
}