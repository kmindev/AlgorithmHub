import java.util.*;

class Solution {

    Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        return solve(orders, course);
    }

    private String[] solve(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        // 1. course 각 원소 개수 만큼 조합 구하기
        for (int menuSize : course) {
            map = new HashMap<>();
            // 2. 조합으로 메뉴 구성 카운트
            for (String order : orders) {
                String[] out = new String[menuSize];
                String[] orderToknes = order.split("");
                Arrays.sort(orderToknes);
                dfs(out, orderToknes, 0, 0);
            }
            // 3. 인기 코스요리 result에 추가
            addResult(result);
        }
        // 4. result 정렬
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
    
    private void addResult(List<String> result) {
        int max = Integer.MIN_VALUE;
        for(int value : map.values()) {
            max = Math.max(max, value);
        }
        
        if(max < 2) {
            return;
        }
        
        for(String key : map.keySet()) {
            if(map.get(key) == max) {
                result.add(key);
            }
        }
    }

    private void dfs(String[] out, String[] orderToknes, int start, int depth) {
        if (depth == out.length) {
            StringBuilder sb = new StringBuilder();
            for(String s : out) {
                sb.append(s);
            }
            String menu = sb.toString();
            map.put(menu, map.getOrDefault(menu, 0) + 1);
            return;
        }

        for (int i = start; i < orderToknes.length; i++) {
            out[depth] = orderToknes[i];
            dfs(out, orderToknes, i + 1, depth + 1);
        }
    }

}