class Solution {
    public int solution(int n) {
        int result = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) { // 3진수로 변환
            sb.append(n % 3);   
            n /= 3;
        }
        sb.reverse();
        
        // (3^0 * 1) + (3^1 * 2) + (3^2 * 3) + (3^3 * 3) 
        for (int i = 0; i < sb.length(); i++) {
            result += Integer.parseInt(sb.substring(i, i + 1)) * Math.pow(3, i);
        }
        return result;
    }
}