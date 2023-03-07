import java.util.*;
import java.io.*;

public class Solution {

	static StringBuilder sb= new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			String input = br.readLine();

			Set<String> numbers = new HashSet<>();
			// 1. 회전
			for(int i=0; i<N/4; i++) {
				// 2. N/4 칸의 숫자 저장
				int cnt = 0;
				String temp = "";
				for(int j=0; j<input.length(); j++) {
					temp += input.charAt((i+j) % input.length());
					cnt++;
					
					if(cnt == N/4) {
//						System.out.println(temp);
						numbers.add(temp);
						temp = "";
						cnt = 0;
					}		
				}
			}
			
			
			
			int[] result = new int[numbers.size()];
			int cnt = 0;
			for (String num : numbers) {
				result[cnt++] = Integer.parseInt(num,16);
			}
			
			Arrays.sort(result);


//			sb.append(Arrays.toString(result));
			sb.append(result[result.length-K]);
			sb.append("\n");
		}

		System.out.println(sb);
	}
}