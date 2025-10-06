import java.util.*;
import java.util.regex.*;

class Solution {

    Set<Set<String>> result = new HashSet<>();
    String[] userIds;
    String[] bannedIds;

    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;

        dfs(new HashSet<>(), 0);
        return result.size();
    }

    private void dfs(Set<String> set, int depth) {
        if (depth == bannedIds.length) {
            result.add(set);
            return;
        }

        for (int i = 0; i < userIds.length; i++) {
            if (set.contains(userIds[i])) {
                continue;
            }

            if (sameId(bannedIds[depth], userIds[i])) {
                set.add(userIds[i]);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(userIds[i]);
            }
        }
    }

    private boolean sameId(String bannedId, String userId) {
        String regex = bannedId.replace("*", ".");
        return Pattern.matches(regex, userId);
    }

}