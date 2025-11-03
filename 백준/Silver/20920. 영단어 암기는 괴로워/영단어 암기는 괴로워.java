import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int M;
    static Map<String, Integer> map = new HashMap<>();
    static List<Word> wordList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (String key : map.keySet()) {
            wordList.add(new Word(key, map.get(key)));
        }

        Collections.sort(wordList);

        for (Word word : wordList) {
            bw.write(word.word + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Word implements Comparable<Word> {
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Word o) {
            if (this.count != o.count) {
                return o.count - this.count;
            }

            if (this.word.length() != o.word.length()) {
                return o.word.length() - this.word.length();
            }

            return this.word.compareTo(o.word);
        }
    }
}