import java.util.*;
import java.io.*;

class Main {  
  public static void main(String args[]) throws IOException{ 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int sum = 0;
    
    String [] str = br.readLine().split("");
    for(int j=0; j<n; j++){
      sum += Integer.parseInt(str[j]);
    }
    
    System.out.println(sum); 
  } 
}