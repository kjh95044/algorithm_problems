import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashSet<String> set = new HashSet<>();
		
		String input = br.readLine();
		
		for(int i=1; i<=input.length(); i++) {
			
			int current = 0;
			while(current+i<=input.length()) {
				set.add(input.substring(current, current + i));
				current++;
			}
			
		}
		
		sb.append(set.size() + "\n");
		System.out.println(sb);
	}
}
