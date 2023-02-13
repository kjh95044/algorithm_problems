import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			
			List<Integer> list = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int cmd_cnt = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cmd_cnt; i++) {
				st.nextToken(); // I 버림
				int idx = Integer.parseInt(st.nextToken());
				int newListCnt = Integer.parseInt(st.nextToken());
				List<Integer> newList = new ArrayList<>();
				for (int j = 0; j < newListCnt; j++) {
					newList.add(Integer.parseInt(st.nextToken()));
				}
				
				list.addAll(idx, newList);
			}
			
			for (int i = 0; i<10 && i < list.size(); i++) {
				sb.append(list.get(i)).append(" ");
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}