import java.util.*;
import java.io.*;

class Main {  
  public static void main(String args[]) throws IOException { 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String word = br.readLine();
    for (char c = 'a' ; c <= 'z' ; c++)
      System.out.print(word.indexOf(c) + " ");
  } 
}