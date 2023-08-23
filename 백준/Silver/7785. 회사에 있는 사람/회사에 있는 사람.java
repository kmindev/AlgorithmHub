import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String enterOrLeave = st.nextToken();
            if (enterOrLeave.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        List<String> list = new ArrayList<>();

        for (String name : set) {
            list.add(name);
        }

        Collections.sort(list, Collections.reverseOrder());

        for(String name : list) {
            System.out.println(name);
        }
    }
}