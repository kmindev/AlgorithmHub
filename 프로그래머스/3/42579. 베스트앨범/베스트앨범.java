import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int songCount = genres.length;
        Map<String, Integer> typeCountMap = new HashMap<>();
        Map<String, List<Song>> typeMap = new HashMap<>();

        for (int i = 0; i < songCount; i++) {
            int musicNum = i;
            String type = genres[i];
            int playCount = plays[i];

            typeCountMap.put(type, typeCountMap.getOrDefault(type, 0) + playCount);
            
            if(!typeMap.containsKey(type)) {
                typeMap.put(type, new ArrayList<>());
            }
            List<Song> songs = typeMap.get(type);
            songs.add(new Song(musicNum, playCount));
        }

        List<String> typesSortedByPlayCount = typeCountMap.keySet().stream()
            .sorted((o1, o2) -> typeCountMap.get(o2) - typeCountMap.get(o1))
            .collect(Collectors.toList());
        
        List<Integer> result = new ArrayList<>();
        for(String type : typesSortedByPlayCount) {
            List<Song> songs = typeMap.get(type);
            Collections.sort(songs);
            System.out.println(songs);
            
            int selectCount = 0;
            for(Song song : songs) {
                if(selectCount == 2) {
                    break;
                }
                selectCount++;
                result.add(song.num);
            }
        }
        
        System.out.println(result);
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    static class Song implements Comparable<Song> {
        int num;
        int playCount;
        
        Song(int num, int playCount) {
            this.num = num;
            this.playCount = playCount;
        }
        
        @Override
        public int compareTo(Song o) {
            if(this.playCount == o.playCount) {
                return this.num - o.num;
            }
            return o.playCount - this.playCount;
        }
        
        @Override
        public String toString() {
            return "num: " + num + " playCount: " + playCount;
        }
    }
}