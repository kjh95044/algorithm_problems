import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static class Point implements Comparable<Point>{
        int x,y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        public int dist(Point p) {
        	return Math.abs(this.x-p.x) + Math.abs(this.y - p.y);
        }
        
        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + "]";
        }
        

		@Override
		public int compareTo(Point o) {
	        //// -32768 ≤ x, y ≤ 32767
	        // 왼쪽위랑 더 가까운 순으로 정렬
			
			return Integer.compare(startPoint.dist(this) , startPoint.dist(o));
			
//			if(x==o.x) {
//				return Integer.compare(y, o.y);
//			}
//			return Integer.compare(x, o.x);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
    }
    
    static final Point startPoint = new Point(-32768, -32768);
    static Point start, end, convStores[];

    static Point getPoint() throws IOException {
        st= new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        return new Point(x,y);
    }
    
    public static void main(String[] args) throws IOException {
        
        

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            convStores = new Point[N];

            Point home = getPoint();
            
            for(int i=0; i<N; i++) {
                convStores[i] = getPoint();
            }
//            Arrays.sort(convStores);
            Point dest = getPoint();
            
            // 맥주 20개가 들어있는 한 박스를 가지고 출발
            // 50m 걸을때마다 한병씩 마신다
            // 거리가 1000넘으면 안된다.
            // 편의점에 들렸을 때 빈 병과 새 맥주를 교체 할수 있다.
            // -32768 ≤ x, y ≤ 32767
            
//            if(home.compareTo(dest)>0) {
//            	start = home;
//            	end = dest;
//            }
//            else {
//            	start = dest;
//            	end = home;
//            }
            start = home;
            end = dest;
            bfs(N);
            
//            sb.append(Arrays.toString(convStores)).append("\n");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static HashMap<Point,Boolean> visited = new HashMap<>();
	private static void bfs(int N) {
		visited.clear();
		Queue<Point> queue = new ArrayDeque<>();
		visited.put(start, true);
		queue.offer(start);
		
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(p.dist(end) <=1000) {
				sb.append("happy");
				return;
			}
			
			for(int i=0; i<convStores.length; i++) {
				// 방문한적 없고, 맥주 20개로 버틸수 있는 곳이면 큐에 넣음
				if(!visited.getOrDefault(convStores[i], false) && convStores[i].dist(p)<=1000) {
					visited.put(convStores[i], true);
					queue.offer(convStores[i]);
				}
			}
		}

		sb.append("sad");
	}
}