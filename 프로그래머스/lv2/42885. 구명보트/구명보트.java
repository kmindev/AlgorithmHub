import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int min = 0;
        
        // 큰값이 작은값 방향으로 이동
        for(int max = people.length-1; min <= max; max--) {
            
            // 작은값은 큰값 방향으로 이동하면서
            // 작은값 + 큰값 <= 무게제한 일 때 탑승 가능하므로 작은값을 큰값으로 이동시켜주면서 결과 증가
            if(people[max] + people[min] <= limit) {
                min++;
            }
            answer++;
        }
        
        return answer;
    }
}