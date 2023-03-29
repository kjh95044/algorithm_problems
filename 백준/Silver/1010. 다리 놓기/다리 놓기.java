import java.util.*;
import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N,M,result;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			isSelected = new boolean[M];
			comb();
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	private static void comb() {
		
		int[][] B = new int[M+1][N+1];
		
		for(int i=0; i<=M; i++) {
			for (int j = 0, end = Math.min(i, N); j<=end; j++) {
				if(j==0 || i==j) B[i][j] = 1;
				else B[i][j] = B[i-1][j-1] + B[i-1][j];
				
			}
			
		}
		result = B[M][N];		
	}
}