import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String,String> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            String temp = st.nextToken();
            if(map.containsKey(temp))
                map.put(temp, Integer.toString(Integer.parseInt(map.get(temp))+1));
            else
                map.put(temp,"1");
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            String token = st2.nextToken();
            bw.write(map.getOrDefault(token, "0"));
            bw.write(" ");
        }

        bw.flush();

    }
}