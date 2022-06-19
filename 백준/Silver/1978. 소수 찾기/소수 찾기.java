import java.util.*;
import java.io.*;

class Main {  
  public static boolean isPrime(int num){
    if (num>=2){
     for(int i=2; i<num; i++){
       if(num%i == 0){
         return false;
       }
      }     
    }
    else
      return false;
    return true;
  }
  
  public static void main(String args[]) throws IOException{
    int result = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] num_list = br.readLine().split(" ");

    for(String num : num_list){
      if(isPrime(Integer.parseInt(num))){
        result++;
      }
    }
    
    System.out.println(result);
  } 
}