import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (String str : info) {
            String[] split = str.split(" ");
            dfs(split, "", 0);
        }

        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] split = query[i].split(" ");
            if (!map.containsKey(split[0])) {
                answer[i] = 0;
            } else {
                String key = split[0];
                int score = Integer.parseInt(split[1]);
                answer[i] = binarySearch(key, score);
            }
        }

        return answer;
    }

    private int binarySearch(String key, int score) {
        List<Integer> scores = map.get(key);
        int start = 0;
        int end = scores.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (scores.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return scores.size() - start;
    }

    private void dfs(String[] p, String str, int depth) {
        if (depth == 4) {
            if (!map.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(p[4]));
            return;
        }
        dfs(p, str + "-", depth + 1);
        dfs(p, str + p[depth], depth + 1);
    }
}