import java.util.*;
import java.io.*;

class Main {  
  public static void main(String args[]) throws IOException   { 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String str1 = st.nextToken();
    String str2 = st.nextToken();
    str1 = String.valueOf(str1.charAt(2)) + str1.charAt(1) + str1.charAt(0);
    str2 = String.valueOf(str2.charAt(2)) + str2.charAt(1) + str2.charAt(0);
    if(Integer.parseInt(str1) > Integer.parseInt(str2))
      System.out.println(str1); 
    else
      System.out.println(str2);
      
  } 
}