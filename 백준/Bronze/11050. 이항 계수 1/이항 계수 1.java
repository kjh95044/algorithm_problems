import java.util.Scanner;

public class Main {

	static int N,R,result;
	static int[] numbers;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		
		comb(0,0);
		System.out.println(result);
	}

	private static void comb(int cnt, int start) {
		if(cnt==R) {
			result++;
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
}