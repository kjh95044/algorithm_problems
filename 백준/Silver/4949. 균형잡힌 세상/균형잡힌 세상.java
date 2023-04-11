import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Character> q = new ArrayDeque<>();
		
		while(true) {
			String input = in.readLine();
			if(input.equals(".")) break;
			
			boolean isPerfect = true;
			
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				switch (c) {
				case '(':
					q.offerLast(c);
					break;
				case '[':
					q.offerLast(c);
					break;
				case ')':
					if(q.isEmpty() || q.pollLast() != '(') {
						isPerfect = false;
					}
					break;
				case ']':
					if(q.isEmpty() || q.pollLast() != '[') {
						isPerfect = false;
					}
					break;
				default:
					break;
				}
				
				if(!isPerfect) break;
			}
			
			if(!q.isEmpty()) { // 괄호가 안 닫힌 경우..... 이걸 생각 못했네
				isPerfect = false;
				q.clear();
			}
			
			if(isPerfect) {
				sb.append("yes").append("\n");
			}else {
				sb.append("no").append("\n");
			}
			
		}
		System.out.println(sb);
	}
}