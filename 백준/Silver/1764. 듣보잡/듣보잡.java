import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		List<String> result = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), 1);
		}
		
		for(int j=0; j<M; j++) {
			String input = br.readLine();
			if(map.containsKey(input)) {
				result.add(input);
			}
		}
		Collections.sort(result);
		sb.append(result.size() + "\n");
		for(String str : result) {
			sb.append(str + "\n");
		}
		
		System.out.println(sb);
	}
}
