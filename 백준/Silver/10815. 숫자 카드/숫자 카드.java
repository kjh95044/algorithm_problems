import java.util.*;
import java.io.*;

class Main { 
  public static int binarySerach(int[] array, int target){
    int start =0;
    int end = array.length - 1;
    int mid = (start+end)/2;

    while(end-start >=0){
      if(array[mid] == target)
        return 1;
      else if(array[mid]>target){
        end= mid -1;
      }
      else{
        start = mid+1;
      }
      mid = (start+end)/2;
    }
    return 0;
  }
  
  public static void main(String args[]) throws IOException { 
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    int m = Integer.parseInt(br.readLine());
    int [] m_array = new int[m];
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    for(int i=0; i<m; i++){
        m_array[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(m_array);
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++){ sb.append(binarySerach(m_array,Integer.parseInt(st2.nextToken())));
      sb.append(" ");
    }
    System.out.println(sb);
  } 
}