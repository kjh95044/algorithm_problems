import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Person implements Comparable<Person>{
    int age;
    String name;

    Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(age, o.age);
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        List<Person> people = new ArrayList<>();

        for(int test_case =1; test_case<=T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Person p = new Person(age,name);
            people.add(p);
        }
        Collections.sort(people);

        for(Person person : people){
            sb.append(person);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}