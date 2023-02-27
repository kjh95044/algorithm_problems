import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] representatives; // 각 원소의 부모 인덱스를 저장할 배열
	
	// 단위 집합 생성
	private static void makeSet() {
		
		representatives = new int[N+1]; // 인덱스 1번부터 사용
		
		// 자신의 부모노드를 자신의 값으로 설정
		for (int i =1; i <= N; i++) {
			representatives[i] = i;
		}
		
	}
	
	private static int findSet(int a) {
		if(representatives[a] == a) {
			return a;
		}
		
		return representatives[a] = findSet(representatives[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		representatives[bRoot] = aRoot;
		return true;
	}

	
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
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (cmd == 0) {
					union(a, b);
				}
				else {
					if(findSet(a) == findSet(b)) {
						sb.append(1);
					}
					else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	
}