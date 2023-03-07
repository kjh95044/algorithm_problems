import java.util.*;
import java.io.*;

public class Main {

	static StringBuilder sb= new StringBuilder();
	static int[]numbers;
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		
		permutation(0);
		System.out.println(sb);
	}

	private static void permutation(int cnt) {
		if(cnt==M) {
			for (int i : numbers) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i=1; i<=N; i++) {
			numbers[cnt] = i;
			permutation(cnt+1);
		}
	}
}