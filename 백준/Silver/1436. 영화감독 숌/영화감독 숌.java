import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		while(N!=0) {
			cnt++;
			if(Integer.toString(cnt).contains("666")) {
				N--;
			}
		}
		sb.append(cnt + "\n");
		System.out.println(sb);
	}
}
