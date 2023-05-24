class Solution {
    public int solution(int n) {
        int result = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            result += Integer.parseInt(sb.substring(i, i + 1)) * Math.pow(3, i);
        }
        return result;
    }
}