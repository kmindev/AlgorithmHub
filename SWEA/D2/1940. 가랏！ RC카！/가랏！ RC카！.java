
import java.util.Scanner;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
            
		int T = sc.nextInt(); // 전체 테스트케이스 수
        
        for (int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();   // 하나의 테스트 안에서의 수
            int speed = 0; // 속도
            int result = 0; // 총 거리
            
            for (int i=0; i<N; i++) {
                int com = sc.nextInt(); // 커멘드    
                      
                if (com == 1)  { // 가속
                    speed+= sc.nextInt();
                } else if (com == 2) { // 감속
                    speed-=sc.nextInt();
                }
                if(speed < 0) speed = 0;
                result += speed;   
            }
            System.out.println("#"+tc+" "+result);
        }
	}
}