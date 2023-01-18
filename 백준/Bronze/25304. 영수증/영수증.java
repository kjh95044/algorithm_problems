import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int T;
		T = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			sum += price * n;
		}
		
		if(sum == total)
			System.out.println("Yes");
		else {
			System.out.println("No");
		}

	}

}
