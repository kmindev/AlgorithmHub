import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String> set = new HashSet<>();
        // 1. 중복 제거
        for (String rep : report) {
            set.add(rep);
        }

        // 2. notifyListHash 만들기
        HashMap<String, List<String>> notifyListHash = new HashMap<>();
        for (String rep : set) {
            String[] split = rep.split(" ");

            List<String> reportList = notifyListHash.getOrDefault(split[1], null);
            if (reportList == null) {
                reportList = new ArrayList<>();
            }
            reportList.add(split[0]);
            notifyListHash.put(split[1], reportList);
        }

        // 3. notifyListHash 기반으로 reportHash 만들기
        HashMap<String, Integer> reportHash = new HashMap<>();

        for (List<String> reportList : notifyListHash.values()) {
            if (reportList.size() >= k) {
                for (String rep : reportList) {
                    reportHash.put(rep, reportHash.getOrDefault(rep, 0) + 1);
                }
            }
        }

        // 4. reportHash 기반으로 answer 배열 채우기
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reportHash.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}