import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int[] numbers;
	static int[] dwarf;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dwarf = new int[9];
		numbers = new int[7];
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		// 순서 상관없이 9개중에 7개로 100 만들면 된다.
		// 조합
		
		comb(0,0,0);
		System.out.println(sb);
	}

	private static void comb(int cnt, int start, int sum) {
		if(cnt == 7) {
			if(sum == 100) {
				for(int idx : numbers) {
					sb.append(dwarf[idx]).append("\n");
				}
			}
			return;
		}
		
		for(int i=start; i<9; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1, sum + dwarf[i]);
		}
	}
}