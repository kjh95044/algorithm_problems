import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int t = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
        int temp = t;
        while (!q.isEmpty()){
            int now = q.poll();
            temp--;
            if(temp>0){
                q.offer(now);
            }
            else{
                list.add(now);
                temp = t;
            }
        }

        System.out.print("<");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if(i!=list.size()-1){
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}