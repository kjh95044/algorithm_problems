import java.util.*;
import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		String input = br.readLine();
		int i = Integer.parseInt(br.readLine());
		System.out.println(input.charAt(i-1));
	}
}