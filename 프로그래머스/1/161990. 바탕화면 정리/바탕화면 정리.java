class Solution {
    public int[] solution(String[] wallpaper) {
        
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;
        
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++) {
                char ch = wallpaper[i].charAt(j);
                if(ch == '#') {
                    lux = Math.min(lux, i);
                    rdx = Math.max(lux, i);
                    luy = Math.min(luy, j);
                    rdy = Math.max(rdy, j);
                }
                
            }
        }
        
        int[] answer = {lux, luy, rdx + 1, rdy + 1};
        return answer;
    }
}