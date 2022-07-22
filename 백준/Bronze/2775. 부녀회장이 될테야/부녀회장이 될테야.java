import java.util.*;
import java.io.*;

class Main {  
  public static void main(String args[]) throws IOException{    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int [][] houses = new int[15][15];
    for(int i=0; i<15; i++){
      int sum= 0;
      for(int j=0; j<15; j++){
        if(i==0){
          houses[i][j] = j;
        }
        else{
          sum += houses[i-1][j];
          houses[i][j] = sum;
        }
      }
    }

    int T = Integer.parseInt(br.readLine());
    for(int i=0; i<T; i++){
      int k = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      sb.append(houses[k][n]);
      sb.append("\n");
    }
    System.out.println(sb);
  } 
}