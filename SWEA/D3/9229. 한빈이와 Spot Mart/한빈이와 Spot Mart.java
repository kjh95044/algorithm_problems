import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int R = 2;
	static int M;
	static int result;
	static int[] kg;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=TC; test_case++) {
			sb.append("#").append(test_case).append(" ");
			
			String[] split = br.readLine().split(" ");
			N = Integer.parseInt(split[0]);
			M = Integer.parseInt(split[1]);
			kg = new int[N];
			numbers = new int[R];
			
			split = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				kg[i] = Integer.parseInt(split[i]);
			}
			
			result = -1;
			combination(0,0);
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void combination(int cnt, int start) {
		
		if(cnt == 2) {
			int sum = numbers[0] + numbers[1];
			if(sum <= M) {
				result = Math.max(result, sum);
			}
			
			return;
		}
		
		
		for(int i=start; i<N; i++) {
			numbers[cnt] = kg[i];
			combination(cnt + 1, i + 1);
		}
	}

}