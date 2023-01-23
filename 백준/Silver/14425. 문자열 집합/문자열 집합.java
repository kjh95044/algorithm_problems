import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		String[] arr1 = new String[N];
		String[] arr2 = new String[M];
		
		for(int i=0; i<N; i++) {
			arr1[i] = br.readLine();
		}
		
		for(int i=0; i<M; i++) {
			arr2[i] = br.readLine();
		}
		
		

		
		for(String str : arr2) {
			for(String str2 : arr1) {
				if(str.equals(str2)) {
					cnt++;
				}
			}
		}
		
		
		
		
		sb.append(cnt + "\n");
		System.out.println(sb);
	}
}
