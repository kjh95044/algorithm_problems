import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine();
			sb.append("#" + test_case + " ");
			Queue<Integer> q = new ArrayDeque<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			int cnt = 0;
			int temp = Integer.MAX_VALUE;
			while(temp>0) {
				temp = q.poll();
				temp-= cnt++ % 5 + 1;
				if(temp<0) {
					temp = 0;
				}
				q.offer(temp);
			}
			
			for(Integer i : q) {
				sb.append(i + " ");
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

}