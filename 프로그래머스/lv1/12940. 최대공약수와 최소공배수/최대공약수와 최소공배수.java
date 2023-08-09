class Solution {
    public int[] solution(int n, int m) {
        int gcdRes = gcd(n, m);
        int lcmRes = lcm(gcdRes, n, m);
        
        int[] answer = {gcdRes, lcmRes};
        return answer;
    }
    
    private int gcd(int n, int m) {
        if(m==0) return n;
        return gcd(m, n % m);
    }
    
    private int lcm(int gcd, int n, int m) {
        return n * m / gcd;
    }
}