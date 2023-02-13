import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;



public class Main {
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] result = new int[N+1];
		
		int[] towers = new int[N+1];
		for (int i = 1; i <= N; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}
		
		result[1] = 0;
		int maxVal = 0;
		int maxIdx = 0;
		
		// index 저장
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int i=1; i<= N; i++) {
			if(maxVal<=towers[i]) {
				if(maxVal<towers[i]) { // 
					result[i] = 0;
				}else { // 
					result[i] = maxIdx;
				}
				
				while(!dq.isEmpty()) {
					dq.clear();
				}
				maxVal = towers[i];
				maxIdx = i;
			}
			else{
				while(!dq.isEmpty()) {
					int nowTowerHeight = towers[i];
					int dqTower = dq.peekLast();
					int dqTowerHeight = towers[dqTower];
					
					if(dqTowerHeight > nowTowerHeight) { // q에 들어있는 타워가 더 높으면 해당 타워 인덱스가 결과
						result[i] = dqTower;
						break;
					}
					else if(dqTowerHeight == nowTowerHeight) { // 높이가 같으면 dq 타워 인덱스가 결과고, dq 타워는 dq에서 제거한다.
						result[i] = dqTower;
						dq.pollLast();
						break;
					}
					else { // 현재 타워가 더 높으면 dq 타워를 제거한다.
						dq.pollLast();
					}
				}
			}
			dq.offer(i);
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}