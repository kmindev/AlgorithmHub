import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();

        int current = arr[0];
        list.add(current);
        for (int i = 1; i < arr.length; i++) {
            if (current != arr[i]) {
                current = arr[i];
                list.add(current);
            }
        }
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
}