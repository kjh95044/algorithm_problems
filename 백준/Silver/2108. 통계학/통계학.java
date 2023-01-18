import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		List<Integer> nums = new ArrayList<Integer>();
		int[] count = new int[8001];
		
		for(int i=0; i<T; i++) {
			nums.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(nums);
		
		double sum = 0;
		for(int i=0; i<T; i++) {
			sum += nums.get(i);
			if(nums.get(i)>=0) {
				count[4000+nums.get(i)] ++;
			}
			else {
				count[4000+nums.get(i)] ++;
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i : count) {
			max = Math.max(i, max);
		}
		
		int cnt =0;
		int result = 0;
		
		for(int i=0; i<8001; i++) {
			if(count[i] == max) {
				if(cnt == 1) {
					result = i;
					break;
				}
				else {
					result = i;
					cnt++;
				}
				
			}
		}
		
		if(result>=4000) {
			result -= 4000;
		}
		else {
			result = -(4000 - result);
		}
		
		
		
		
		System.out.println(Math.round(sum/T));
		System.out.println(nums.get((T/2)));
		System.out.println(result);
		System.out.println(Collections.max(nums) - Collections.min(nums));
	}

}