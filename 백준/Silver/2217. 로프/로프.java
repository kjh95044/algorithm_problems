import java.util.*;

class Main {  
  public static void main(String args[]) { 
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<Integer> rope_list = new ArrayList<>();
    int sum = 0;
    int count = 0;
    int result = 0;
    
    for(int i=0; i<n; i++){
      rope_list.add(sc.nextInt());
    }
    Collections.sort(rope_list,Collections.reverseOrder());
    for(int value : rope_list){
      sum += value;
        count += 1;
        if(count == 1){
          result = value;
        }
        else if(value*count > result){
          result = Math.max(value*count, result);
        }
    }
    System.out.println(result);
  } 
}