import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int K = Integer.parseInt(split[1]);
		
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < N+1; i++) {
			list.add(i);
		}
		
		sb.append("<");
		int idx = 0;
		while(!list.isEmpty()) {
			idx = (idx + (K-1)) % list.size();
			sb.append(list.get(idx));
			list.remove(idx);
			
			if(list.size()!=0) {
				sb.append(", ");
			}
		}
		sb.append(">");
		
		System.out.println(sb);
	}
}