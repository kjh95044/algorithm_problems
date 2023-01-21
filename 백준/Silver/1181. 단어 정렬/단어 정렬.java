import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int test_case=0; test_case<T; test_case++){
            String input = br.readLine();
            if(!list.contains(input))
                list.add(input);
        }
        Comparator<String> comparator = (o1, o2) -> {
            if(o1.length() == o2.length()) return o1.compareTo(o2);
            return Integer.compare(o1.length(), o2.length());
        };

        list.sort(comparator);

        for(String str : list){
            sb.append(str);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}