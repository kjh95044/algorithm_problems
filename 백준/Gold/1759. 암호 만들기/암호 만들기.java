import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static char[] amho, numbers;
	static int L, C;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// L은 몇글자 암호인지
		// C는 주어진 문자 갯수
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		amho = new char[C];
		isSelected = new boolean[C];
		numbers = new char[L];

		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			amho[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(amho);
		comb(0, 0);
		System.out.println(sb);
	}

	private static void comb(int cnt, int start) {
		if(cnt == L) {
			// 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음
			int aeiouCnt = 0;
			int elseCnt = 0;
			StringBuilder temp = new StringBuilder();
			
			boolean isAmho = false;
			for(int i=0; i< L; i++) {
				if(numbers[i] == 'a' || 
						numbers[i] == 'e' || 
						numbers[i] == 'i' || 
						numbers[i] == 'o' || 
						numbers[i] == 'u') {
					aeiouCnt ++;
				}
				else {
					elseCnt++;
				}
				if(aeiouCnt >=1 && elseCnt >= 2) {
					isAmho = true;
				}
				temp.append(numbers[i]);
			}
			
			if(isAmho) {
				sb.append(temp).append("\n");
			}
			
			return;
		}
		
		for(int i=start; i<C; i++) {
			numbers[cnt] = amho[i];
			comb(cnt + 1, i + 1);
		}
	}
	
	
}