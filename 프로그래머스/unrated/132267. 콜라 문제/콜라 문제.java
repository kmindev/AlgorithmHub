class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int namuge = 0;
        while(n >= a) {
            namuge = (n % a);
            
            n = ((n / a) * b);

            answer += n;
            
            n = namuge + n;
        }
        
        return answer;
    }
}