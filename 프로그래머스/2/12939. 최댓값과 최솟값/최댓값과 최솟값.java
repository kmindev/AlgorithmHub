class Solution {
    public String solution(String s) {
        String[] tokens = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(String token : tokens) {
            max = Math.max(max, Integer.valueOf(token));
            min = Math.min(min, Integer.valueOf(token));
        }

        return min + " " + max;
    }
}