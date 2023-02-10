import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	private static StringBuilder sb = new StringBuilder();
	private static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = 10;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			int N = Integer.parseInt(br.readLine());
			String bracket = br.readLine();
			sb.append(solution(bracket));
			
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	private static int solution(String bracket) {
		for(char c : bracket.toCharArray()) {
			boolean isAvailable = true;
			switch (c) {
			case ')':
				isAvailable = checkAvailable('(');
				break;
			case ']':
				isAvailable = checkAvailable('[');
				break;
			case '}':
				isAvailable = checkAvailable('{');
				break;
			case '>':
				isAvailable = checkAvailable('<');
				break;
			default :
				stack.push(c);
				break;
			}
			if(!isAvailable) {
				return 0;
			}
		}
		return 1;
	}
	
	private static boolean checkAvailable(char c) {
		if(stack.isEmpty()) {
			return false;
		}
		else {
			if(c == stack.pop()) {
				return true;
			}
			else {
				return false;
			}
		}
	}
}