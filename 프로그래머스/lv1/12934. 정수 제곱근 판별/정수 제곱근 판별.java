import java.math.*;

class Solution {
    public long solution(long n) {
        boolean check = false;
        long i = 1;
        for(; i<=Math.sqrt(n); i++) {
            if(i * i == n) {
                check = true;
                break;
            }
        }
        
        return check ? (i + 1) * (i + 1) : -1;
    }
}