import java.util.*;

class Main {  
  public static void main(String args[]) { 
    Scanner sc = new Scanner(System.in);
    double hours = sc.nextDouble();
    double minutes = sc.nextDouble();
    double input_minutes = sc.nextDouble();

    double sum_all = hours * 60 + minutes + input_minutes;
    
    int result_hour = (int)sum_all/60 % 24;
    int result_minutes = (int)sum_all % 60;
    
    
    System.out.println(result_hour + " " + result_minutes); 
    
  } 
}