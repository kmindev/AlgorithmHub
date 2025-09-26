import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students.add(new Student(name, korean, english, math));
        }

        Collections.sort(students);

        for (Student student : students) {
            bw.write(student.name + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;

        Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }


        @Override
        public int compareTo(Student o) {
            if (this.korean != o.korean) {
                return Integer.compare(o.korean, this.korean);
            }

            if (this.english != o.english) {
                return Integer.compare(this.english, o.english);
            }

            if (this.math != o.math) {
                return Integer.compare(o.math, this.math);
            }

            return this.name.compareTo(o.name);
        }
    }
}