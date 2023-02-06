import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	
	static String recurUnderbar = "";
	static StringBuilder sb = new StringBuilder();
	
	private static void solution(int num) {
		String underbar = recurUnderbar;
		
		if(num==0) {
			sb.append(underbar + "\"재귀함수가 뭔가요?\"" + "\n");
			sb.append(underbar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"" + "\n");
			sb.append(underbar + "라고 답변하였지." + "\n");
			return;
		}
		
		sb.append(underbar + "\"재귀함수가 뭔가요?\"" + "\n");
		sb.append(underbar + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어." + "\n");
		sb.append(underbar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지." + "\n");
		sb.append(underbar + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"" + "\n");
	
		recurUnderbar += "____";
		solution(num-1);
		
		sb.append(underbar + "라고 답변하였지." + "\n");
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다." + "\n");
		solution(num);
		System.out.println(sb);
		
	}
}