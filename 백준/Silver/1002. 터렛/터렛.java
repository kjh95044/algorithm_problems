import java.util.*;
import java.io.*;

class Main {  
  public static void main(String args[]) throws IOException   { 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int [] result = new int[n];
    
    for(int i=0; i<n; i++){
      String [] str = br.readLine().split(" ");
      double x1 = Double.parseDouble(str[0]);
      double y1 = Double.parseDouble(str[1]);
      double r1 = Double.parseDouble(str[2]);
      double x2 = Double.parseDouble(str[3]);
      double y2 = Double.parseDouble(str[4]);
      double r2 = Double.parseDouble(str[5]);

      double d = Math.sqrt((Math.pow(Math.abs(x1-x2),2) + Math.pow(Math.abs(y1-y2),2)));
      if(d == 0){
        if(r1 == r2)
          result[i] = -1;
        else
          result[i] = 0;
      }
      else{
        if(r1 + r2 == d || Math.abs(r1-r2) == d){
          result[i] = 1;
        }
        else if(Math.abs(r1-r2) < d && d < r1+r2){
          result[i] = 2;
        }
        else
          result[i] = 0;
        
        
      }
            
    }
    for(int i=0; i<n;i++)
      System.out.println(result[i]);
  }
}