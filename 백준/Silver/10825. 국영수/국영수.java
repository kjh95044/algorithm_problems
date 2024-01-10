import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static class Student implements Comparable<Student>{
        String name;
        int koreanScore;
        int englishScore;
        int mathScore;

        public Student(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        @Override
        public int compareTo(Student student){
            if(student.koreanScore != this.koreanScore) return student.koreanScore - this.koreanScore;
            if(student.englishScore != this.englishScore) return this.englishScore - student.englishScore;
            if(student.mathScore != this.mathScore) return student.mathScore - this.mathScore;
            return this.name.compareTo(student.name);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Student student = new Student(
                    st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );

            students[i] = student;
        }

        Arrays.sort(students);

        for(int i=0; i<N; i++){
            sb.append(students[i].name).append("\n");
        }

        System.out.println(sb);
    }

}