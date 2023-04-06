import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] input = in.readLine().split(" ");
			int[] xyz = new int[3];
			xyz[0] = Integer.parseInt(input[0]);
			xyz[1] = Integer.parseInt(input[1]);
			xyz[2] = Integer.parseInt(input[2]);
			
			Arrays.sort(xyz);
			
			int x = xyz[0];
			int y = xyz[1];
			int z = xyz[2];
			
			if(x==0&&y==0&&z==0) {
				break;
			}

			
			if((x*x + y*y) == z * z) {
				System.out.println("right");
			}
			else {
				System.out.println("wrong");
			}
		}
	}
}