import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int R, C, result;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		String[] strs = new String[R];

		for (int i = 0; i < strs.length; i++) {
			strs[i] = in.readLine();
		}

		// hashSet을 써보자!
		
		// 처음 등록

		for (int i = 0; i < C; i++) {
			StringBuilder temp = new StringBuilder();
			for (int j = 0; j < R; j++) {
				temp.append(strs[j].charAt(i));
			}
			set.add(temp.toString());	
		}
		
		if(set.size() != C) {
			System.out.println(0);
			return;
		}
		
		// set을 뒤지면서 앞에 글자를 하나씩 제거 한다.
		// 제거했을때 이전과 사이즈가 달라지면 중복이 생긴거다.
		// 중복이 생겼으면 종료시킨다.
		
		int size = set.size();
		
		while(size!=0) {
//			boolean flag = true;
//			System.out.println(set);
			Set<String> newSet = new HashSet<>();

			for (String s : set) {
				newSet.add(s.substring(1, s.length()));
			}
			
//			System.out.println(newSet);
			set = newSet;
//			if(!flag) break;
			if(set.size() == size) {
				result ++;
			}else {
				break;
			}
		}
		

//		while (true) {
//			boolean flag = true;
//			if(start == R) break;
//			for (int i = 0; i < C; i++) {
//				StringBuilder temp = new StringBuilder();
//				for (int j = start; j < R; j++) {
//					temp.append(strs[j].charAt(i));
//				}
//
//				if (map.containsKey(temp.toString())) {
//					flag = false;
//					break;
//				} else {
//					map.put(temp.toString(), 1);
//				}
//				
//			}
//
//
////			System.out.println(map);
//			if(flag) result++;
//			else break;
//			start++;
//			map.clear();
//		}

		System.out.println(result);
	}
}