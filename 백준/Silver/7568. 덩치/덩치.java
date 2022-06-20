import java.util.*;
import java.io.*;

class Main {  
  public static void main(String args[]) throws IOException { 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int [][] a = new int [n][2];
    int rank;
    int [] rank_list = new int [n];
    int count = 0;
    
    for(int i=0; i<n ; i++){
      String [] str = br.readLine().split(" ");
      a[i][0] = Integer.parseInt(str[0]);
      a[i][1] = Integer.parseInt(str[1]);
    }    

    for(int [] num : a){
      rank = 1;
      for(int i=0; i<a.length; i++){
        if(a[i][0] > num[0] && a[i][1] > num[1]){
          rank ++;
        }
      }
      rank_list[count] = rank;
      count ++;
    }

    for(int r : rank_list){
      System.out.print(r + " ");
    }
  } 
}