import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int num = 0;
			while(st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
			}
			
			switch (cmd) {
			case "push_front":
				dq.offerFirst(num);
				break;
			case "push_back":
				dq.offerLast(num);
				break;
			case "pop_front":
				sb.append((dq.isEmpty()? -1 :dq.pollFirst()) + "\n");
				break;
			case "pop_back":
				sb.append((dq.isEmpty()? -1 : dq.pollLast()) + "\n");
				break;
			case "size":
				sb.append(dq.size() + "\n");
				break;
			case "empty":
				sb.append((dq.isEmpty()? 1 : 0) + "\n");
				break;
			case "front":
				sb.append((dq.isEmpty()? -1 : dq.peekFirst()) + "\n");
				break;
			case "back":
				sb.append((dq.isEmpty()? -1 : dq.peekLast()) + "\n");
				break;

			}
		}
		System.out.println(sb);
	}
}