import java.util.*;
import java.io.*;

class Main {  
  public static void main(String args[]) throws IOException { 
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    List<Integer> nums = new ArrayList<>();
    int n = Integer.parseInt(bf.readLine());
    for(int i=0; i<n;i++){
      nums.add(Integer.parseInt(bf.readLine()));
    }
    Collections.sort(nums, Collections.reverseOrder());

    for (int num : nums){
      bw.write(num + "\n");
    }
    
    //nums.forEach(value -> bw.write(Integer.toString(value) + "\n"));
    bw.flush();
    bw.close();
  } 
}