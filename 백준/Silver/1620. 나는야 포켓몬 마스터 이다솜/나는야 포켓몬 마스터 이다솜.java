import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, String> numMap = new HashMap<>();
		HashMap<String, Integer> strMap = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			numMap.put(i+1, input);
			strMap.put(input, i+1);
		}
		
		for(int i=0; i<M; i++) {
			String input = br.readLine();
			
			if(input.matches("^[0-9]*$")) {
				sb.append(numMap.get(Integer.parseInt(input)));
			}
			else {				
				sb.append(strMap.get(input));
			}
			sb.append("\n");
			
		}

		System.out.println(sb);
	}
}