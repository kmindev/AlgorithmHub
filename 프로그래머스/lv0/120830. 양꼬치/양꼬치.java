class Solution {
    public int solution(int n, int k) {
        int meat = n * 12000;
        int drink = (k * 2000) -  (n / 10) * 2000;
        return meat + drink;
    }
}