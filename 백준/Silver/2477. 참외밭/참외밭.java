import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[6][2];		
		
		
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int width = 0;
		int height = 0;
		
		for(int i=0; i<6; i++) {
			if(map[i][0] == 1 || map[i][0] == 2) {
				width = Math.max(width, map[i][1]);
			}
			else {
				height = Math.max(height, map[i][1]);
			}
		}
		
		int smallRect = 1;
		
		int sum = 0;
		for(int i=0; i<6; i++) {
			if(map[i][0] == map[(i+2)%6][0]) {
				smallRect *= map[(i+1)%6][1];
			}
		}
		sum = width * height - smallRect;
		sb.append(sum * N +"\n");

		System.out.println(sb);
	}
}
