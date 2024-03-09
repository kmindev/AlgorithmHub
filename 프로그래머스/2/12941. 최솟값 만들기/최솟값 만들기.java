import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<A.length; i++) {
            int mul = A[i] * B[A.length - i - 1];
            answer += mul;
        }

        return answer;
    }
}