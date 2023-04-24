import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Character> list;
    static int result = Integer.MAX_VALUE;
    static HashMap<Character, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();

        char[] inputArray = input.toCharArray();

        for(int i=0; i<inputArray.length; i++) {
            List<Integer> temp = map.get(inputArray[i]);
            if (temp == null) {
                temp = new ArrayList<>();
            }
            temp.add(i);
            map.put(inputArray[i], temp);
        }

        
        list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        dfs(0, 0, 0);

        // 엔터를 누르는 갯수는 출력할 문자의 갯수와 같다.
        result += input.length();

        System.out.println(result);
    }

    private static void dfs(int index, int cur, int cnt) {

        if(cnt > result) return;

        if(index == list.size()){
            if(cnt < result){
                result = cnt;
            }
            return;
        }

        char c = list.get(index);
        int max = Collections.max(map.get(c));
        int min = Collections.min(map.get(c));

//        System.out.println(min + " " + max);

        if(max == min){
            dfs(index+1,max,cnt + Math.abs(cur - min));
        }else {
            dfs(index+1,max,cnt + Math.abs(cur - min) + Math.abs(max - min));
            dfs(index+1,min,cnt + Math.abs(cur - max) + Math.abs(max - min));
        }
    }
}