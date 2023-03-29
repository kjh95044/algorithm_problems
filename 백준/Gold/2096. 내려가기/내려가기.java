import java.util.*;
import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[][] DP = new long[N][3];
		long[][] DP2 = new long[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			DP[i][0] = Integer.parseInt(st.nextToken());
			DP[i][1] = Integer.parseInt(st.nextToken());
			DP[i][2] = Integer.parseInt(st.nextToken());
			
			DP2[i][0] = DP[i][0];
			DP2[i][1] = DP[i][1];
			DP2[i][2] = DP[i][2];
		}
	
		
		for(int i=1; i<N; i++) {
			DP[i][0] += Math.max(DP[i-1][0], DP[i-1][1]);
			DP[i][1] += Math.max(Math.max(DP[i-1][0], DP[i-1][1]), DP[i-1][2]);
			DP[i][2] += Math.max(DP[i-1][1], DP[i-1][2]);
		}
		
		for(int i=1; i<N; i++) {
			DP2[i][0] += Math.min(DP2[i-1][0], DP2[i-1][1]);
			DP2[i][1] += Math.min(Math.min(DP2[i-1][0], DP2[i-1][1]), DP2[i-1][2]);
			DP2[i][2] += Math.min(DP2[i-1][1], DP2[i-1][2]);
		}
		
		sb.append(Math.max(Math.max(DP[N-1][0], DP[N-1][1]), DP[N-1][2])).append(" ");
		sb.append(Math.min(Math.min(DP2[N-1][0], DP2[N-1][1]), DP2[N-1][2]));
	
		System.out.println(sb);
	}
}