import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		/*
		 * 1. 입력 파일 읽어들이기
		 */
		// System.setIn(new FileInputStream("res/17478_input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> kue = new ArrayList<Integer>();
			for (int i = 0; i < 9; i++) {
				kue.add(Integer.parseInt(st.nextToken()));
			}
			int[] yin = new int[9];
			int cnt = 0;
			for(int i=1; i<=18; i++) {
				if(!kue.contains(i)) {
					yin[cnt++] = i;
				}
			}
			
			Arrays.sort(yin);
			int win = 0;
			int lose = 0;
			
			do {
				int winSum = 0;
				int loseSum = 0;
				for(int i=0; i<9; i++) {
					if(kue.get(i) > yin[i]) {
						winSum += kue.get(i) + yin[i];
					}
					else {
						loseSum += kue.get(i) + yin[i];
					}
				}
				if(winSum>loseSum) {
					win++;
				}
				else if(winSum<loseSum) {
					lose++;
				}
			}while(np(yin));
			
			sb.append(win).append(" ").append(lose).append("\n");
		}


		System.out.println(sb);
	}
	
	private static boolean np(int[] input) {
		
		int n = input.length;
		
		// step1. 뒤쪽부터 꼭대기를 찾는다. (꼭대기 바로 앞이 교환할 자리)
		int i = n-1;
		while(i>0 && input[i-1]>=input[i]) --i;
		if(i==0) return false;
		
		// step2. 꼭대기 바로 앞(i-1)자리에 교환할 값을 뒤쪽부터 찾는다.
		int j = n-1;
		while(input[i-1]>= input[j]) --j;
		
		// step3. 꼭대기 바로 앞(i-1)자리와 그 자리값보다 한단계 큰 자리(j) 수와 교환
		swap(input, i-1, j);
		
		// step4. 꼭대기부터 맨 뒤까지 오름차순으로 정렬
		int k = n -1;
		while(i<k) {
			swap(input, i++, k--);
		}
		return true;
	}

	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}