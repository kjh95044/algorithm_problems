import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[] representatives;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			representatives = new int[N+1];
			makeSet();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			
			int cnt=0;
			for(int i=1; i<=N; i++) {
				if(representatives[i] == i) {
					cnt++;
				}
			}
			

			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		representatives[bRoot] = aRoot;
		return true;
	}

	private static int findSet(int a) {
		if(representatives[a] == a) {
			return a;
		}
		
		return representatives[a] = findSet(representatives[a]);
	}

	private static void makeSet() {
		for(int i=1; i<=N; i++) {
			representatives[i] = i;
		}
	}
}