class Solution {
    public int solution(int[][] dots) {
        int x1 = dots[0][0]; // x 값 하나 지정
        int x2 = dots[1][0] == x1 ? dots[2][0] : dots[1][0]; // x2에 x1과의 다른 값을 저장

        int y1 = dots[0][1]; // y 값 하나 지정
        int y2 = dots[1][1] == y1 ? dots[2][1] : dots[1][1]; // y2에 y1과의 다른 값을 저장

        return Math.abs(x1 - x2) * Math.abs(y1 - y2); // 가로 * 세로
    }
}