import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int result = 100000;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			char[] readLine = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = readLine[j];
			}
		}
		
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				boolean isChanged = false;
				int cnt = 0;
				int cnt2 = 0;
				char firstChar = map[i][j];
				for(int x=0; x<8; x++) {
					for(int y=0; y<8; y++) {
						if(isChanged) {
							if(map[i+x][j+y] != firstChar) {
								cnt2++;
							}
							else {
								cnt++;
							}
						}
						else {
							if(map[i+x][j+y] == firstChar) {
								cnt2++;
							}
							else {
								cnt++;
							}
						}
						isChanged = !isChanged;
					}
					isChanged = !isChanged;
				}
				cnt = Math.max(cnt, cnt2);
				result = Math.min(result, 64-cnt);
			}
			
			
			
		}
		sb.append(result + "\n");
		System.out.println(sb);
	}

}