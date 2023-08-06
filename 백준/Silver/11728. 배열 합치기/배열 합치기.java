import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> result = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            result.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            result.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();

        for(int res : result) {
            sb.append(res + " ");
        }

        System.out.print(sb.toString());

    }
}