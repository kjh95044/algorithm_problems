
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point implements Comparable<Point>{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(y==o.y) return Integer.compare(x, o.x);
        return Integer.compare(y,o.y);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

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
            sb.append(p.x + " " + p.y + "\n");
        }
        System.out.println(sb);
    }
}