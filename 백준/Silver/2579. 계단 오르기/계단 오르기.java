import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] values = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			values[i] = Integer.parseInt(in.readLine());	
		}
		// 0이면 붙어있는거
		// 1이면 점프한거
		
		int[] DP = new int [N+1];

		
		DP[1] = values[1];
		
		if(N>=2) {
			DP[2] = values[2] + values[1];
		}
		
		for (int i = 3; i <= N; i++) {
			DP[i] = Math.max(values[i-1] + DP[i-3], DP[i-2]) + values[i];
		}
		
		System.out.println(DP[N]);
	}
}