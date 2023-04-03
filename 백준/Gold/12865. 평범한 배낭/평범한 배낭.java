import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] D = new int[N+1][K+1]; // 몇번째 물건, 총량
		
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()); // 무게 W, 가치 V
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			for(int j=1; j<=K; j++) {
				if(W>j) {
					D[i][j] = D[i-1][j];
				}
				else {
					D[i][j] = Math.max(D[i-1][j], V + D[i-1][j - W]);
				}
			}
			
			
			
		}
		System.out.println(D[N][K]);
	}

}