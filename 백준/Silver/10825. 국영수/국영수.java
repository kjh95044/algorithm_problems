import java.io.BufferedReader;
import java.io.InputStreamReader;
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
            if(student.koreanScore > this.koreanScore){
                return 1;
            }else if(student.koreanScore == this.koreanScore){
                if(student.englishScore < this.englishScore){
                    return 1;
                } else if (student.englishScore == this.englishScore) {
                    if(student.mathScore > this.mathScore){
                        return 1;
                    } else if (student.mathScore == this.mathScore) {
                        return this.name.compareTo(student.name);
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Student student = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            students.add(student);
        }

        Collections.sort(students);

        for(int i=0; i<N; i++){
            sb.append(students.get(i).name).append("\n");
        }

        System.out.println(sb);
    }

}