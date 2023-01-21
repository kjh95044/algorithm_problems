import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {    
public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        Integer[] arr = new Integer[n];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            int value = Integer.parseInt(st.nextToken());
            set.add(value);
            arr[i] = value;
        }

        Integer[] setArray = set.toArray(new Integer[0]);
        Arrays.sort(setArray);

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i< setArray.length; i++){
            map.put(setArray[i], i);
        }

        for(int value : arr){
            sb.append(map.get(value) + " ");
        }
        System.out.println(sb);
    }
}