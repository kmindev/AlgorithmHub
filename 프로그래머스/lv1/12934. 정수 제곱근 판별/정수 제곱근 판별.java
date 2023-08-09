import java.math.*;

class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        
        return (int)sqrt == sqrt ? ((long)sqrt + 1) * ((long)sqrt + 1) : -1;
    }
}