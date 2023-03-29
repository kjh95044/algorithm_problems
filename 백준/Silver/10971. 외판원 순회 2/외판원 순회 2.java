import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N,result = Integer.MAX_VALUE;
	static int map[][];
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		numbers = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		permutation(0);
		
		System.out.println(result);
	}

	private static void permutation(int num) {
		if(num == N) {
			int sum = 0;
			for(int i=1; i<N; i++) {
				if(map[numbers[i-1]][numbers[i]] == 0) {
					return;
				}
				sum += map[numbers[i-1]][numbers[i]];
			}
			if(map[numbers[N-1]][numbers[0]]==0) {
				return;
			}
			sum += map[numbers[N-1]][numbers[0]];
			result = Math.min(result, sum);
			return;
		}
		
		for(int i = 0; i< N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			numbers[num] = i;
			permutation(num + 1);
			isSelected[i] = false;
		}
		
	}
}