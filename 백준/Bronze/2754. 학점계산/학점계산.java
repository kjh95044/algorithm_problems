import java.util.*;
import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		/*
		 * A+: 4.3, A0: 4.0, A-: 3.7 B+: 3.3, B0: 3.0, B-: 2.7 C+: 2.3, C0: 2.0, C-: 1.7
		 * D+: 1.3, D0: 1.0, D-: 0.7 F: 0.0
		 */

		String input[] = br.readLine().split("");
		double score = 0.0;
		switch (input[0]) {
		case "A":
			score = 4.0;
			break;

		case "B":
			score = 3.0;
			break;
		case "C":
			score = 2.0;
			break;
		case "D":
			score = 1.0;
			break;
		case "F":
			score = 0.0;
			break;
		}
		
		if(!input[0].equals("F")) {
			if(input[1].equals("+")) {
				score += 0.3;
			}
			else if(input[1].equals("-")) {
				score -= 0.3;
			}
		}
		System.out.println(score);
	}
}