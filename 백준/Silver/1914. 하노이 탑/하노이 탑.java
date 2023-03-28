/* Online Java Compiler and Editor */
import java.util.*;
import java.io.*;
import java.math.*;
public class Main {

     	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void hanoi(int n, int from, int temp, int to) {
		// 종료 조건
		if (n == 0) {
			return;
		}

		hanoi(n - 1, from, to, temp);
		sb.append(from).append(" ").append(to).append("\n");
		hanoi(n - 1, temp, from, to);
	}

	public static void main(String[] args) throws IOException {
		// 하노이를 어떻게 풀면 잘 풀었다고 소문이 날까?
		// 재귀인건 확실한데....재귀가 참 헷갈린단 말이지...

		// 전체 문제를 작은 부분문제로 해결가능한지 따져보기
		// 함수의 역할 명확히 정의하기
		// 함수의 결정요인을 매개변수로 정의

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		BigInteger base = BigInteger.valueOf(2);
		sb.append((base.pow(N).subtract(BigInteger.valueOf(1)))).append("\n");
		if (N <= 20) {
			hanoi(N, 1, 2, 3);
		}
		System.out.println(sb);

	}
}