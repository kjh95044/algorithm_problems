import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] switches;

	public static void main(String[] args) throws Exception {

		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int switchNum = Integer.parseInt(br.readLine());
		switches = new int[switchNum];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < switchNum; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		int studentNum = Integer.parseInt(br.readLine());

		// 풀이 시작
		// 남학생이면 받은수 배수의 스위치 상태를 바꿈
		// 여학생이면 받은수를 기준으로 대칭을 이루면 그 구간 상태를 모두 바꾸고,
		// 그렇지 않으면 받은수의 스위치만 상태 변경

		for (int i = 0; i < studentNum; i++) {
			String[] input = br.readLine().split(" ");
			boolean isMan = false;
			int selectedSwitch = Integer.parseInt(input[1]);
			if (Integer.parseInt(input[0]) == 1) {
				isMan = true;
			}
			if (isMan) {
				for (int j = selectedSwitch; j < switchNum + 1; j += selectedSwitch) {
					changeSwitch(j-1);
				}
			} else {
				int cnt = 1;
				int ss = selectedSwitch -1;
				changeSwitch(ss);
				while(true) {
					if(ss+cnt<switchNum 
							&& ss-cnt>=0 
							&& switches[ss-cnt] == switches[ss+cnt]
							) {
						changeSwitch(ss-cnt);
						changeSwitch(ss+cnt);
						cnt ++;
					}
					else {
						break;
					}
				}
			}
		}
		for(int i=0; i<switchNum; i++) {
			if(i!=0 && i%20 == 0) {
				System.out.println();
			}
			System.out.print(switches[i] + " ");
		}
	}

	private static void changeSwitch(int i) {
		if (switches[i] == 1) {
			switches[i] = 0;
		} else {
			switches[i] = 1;
		}
	}
}