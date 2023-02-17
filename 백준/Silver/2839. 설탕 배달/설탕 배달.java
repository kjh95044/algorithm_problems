import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = Integer.MAX_VALUE;
		
		for(int i=0; i<=N; i+=3) {
			for(int j=0; j<=N; j+=5) {
				if(i+j == N) {
					result = Math.min(result, i/3 + j/5);
				}
			}
		}
		if(result == Integer.MAX_VALUE) {
			result = -1;
		}
		System.out.println(result);
	}
}