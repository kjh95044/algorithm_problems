import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int D[] = new int[N+1];
		
		if(N==1) {
			System.out.println(1);
			return;
		}

		D[0] = 1;
		D[1] = 1;
		D[2] = 2;
		
		for(int i=3; i<=N; i++) {
			D[i] = (D[i-1] + D[i-2])%10007;
		}
		System.out.println(D[N]);
	}

}