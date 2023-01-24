import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			map.put(st.nextToken(), "");
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			String input = st.nextToken();
			if(map.containsKey(input)) {
				map.remove(input);
			}
			else {
				map.put(input, "");
			}
		}
		
		sb.append(map.size()+"\n");

		System.out.println(sb);
	}
}
