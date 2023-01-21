
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point implements Comparable<Point>{
    private int x;
    private int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    @Override
    public int compareTo(Point o) {
        if(x == o.x) return Integer.compare(y, o.y);
        return Integer.compare(x, o.x);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer[]> map = new HashMap<>();
        List<Point> points = new ArrayList<>();

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Point p = new Point(x,y);
            points.add(p);
        }

        Collections.sort(points);
        for(Point p : points){
            sb.append(p.getX() + " " + p.getY() + "\n");
        }

        System.out.println(sb);

    }
}