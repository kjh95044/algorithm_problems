import java.util.*;
import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
//		System.out.println((char)65);
//		System.out.println((char)90);
//		
//		System.out.println((char)97);
//		System.out.println((char)122);
//
		String input = br.readLine();
		for (char c : input.toCharArray()) {
			if(c>=65 && c<=90) {
				sb.append((char)(c+32));
			}
			else if(c>=97 && c<=122)
				sb.append((char)(c-32));
		}
		System.out.println(sb);
	}
}