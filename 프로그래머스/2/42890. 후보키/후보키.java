import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<String> combinations = new ArrayList<>();
    List<String> candidates = new ArrayList<>();
    List<String> unique = new ArrayList<>();

    public int solution(String[][] relation) {
        // 속성 조합을 구한다. [0, 1, 2, 3, 01 ... 0123]
        int columnLength = relation[0].length;
        boolean[] visited = new boolean[columnLength];
        for (int i = 1; i <= columnLength; i++) {
            combination(new StringBuilder(), visited, i, 0, 0);
        }

        // 유일한 속성키를 구한다.
        for (int i = 0; i < combinations.size(); i++) {
            String target = combinations.get(i);
            if (isUnique(relation, target)) {
                unique.add(target);
            }
        }

        // unique에서 최소성을 만족하는 키를 구한다.
        unique.sort((o1, o2) -> o1.length() == o2.length() ?
            o1.compareTo(o2) : o1.length() - o2.length());
        for (int i = 0; i < unique.size(); i++) {
            String target = unique.get(i);
            if (isMin(target)) {
                candidates.add(target);
            }
        }

        return candidates.size();
    }

    private void combination(StringBuilder sb, boolean[] visited, int count, int start, int depth) {
        if (depth == count) {
            combinations.add(sb.toString());
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            sb.append(i);
            combination(sb, visited, count, i + 1, depth + 1);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

    private boolean isUnique(String[][] relation, String target) {
        Set<String> set = new HashSet<>();
        for (int j = 0; j < relation.length; j++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < target.length(); k++) {
                int key = target.charAt(k) - '0';
                sb.append(relation[j][key]);
            }
            set.add(sb.toString());
        }

        return set.size() == relation.length;
    }

    private boolean isMin(String target) {
        Set<Integer> set = new HashSet<>();
        for (char ch : target.toCharArray()) {
            set.add(ch - '0');
        }

        for (String candidate : candidates) {
            int check = 0;
            for (char ch : candidate.toCharArray()) {
                int i = ch - '0';
                if (!set.contains(i)) {
                    break;
                }
                check++;
            }
            if (check == candidate.length()) {
                return false;
            }
        }
        return true;
    }
}