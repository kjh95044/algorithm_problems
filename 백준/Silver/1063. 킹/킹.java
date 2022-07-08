import java.util.*;
import java.io.*;

public class Main {
    public static class Position{
        char a;
        char b;

        Position(char a, char b){
            this.a = a;
            this.b = b;
        }

        void Move(String move){
            switch (move) {
                case "R":
                    this.a++;
                    break;
                case "L":
                    this.a--;
                    break;
                case "B":
                    this.b--;
                    break;
                case "T":
                    this.b++;
                    break;
                case "RT":
                    this.a++;
                    this.b++;
                    break;
                case "LT":
                    this.a--;
                    this.b++;
                    break;
                case "RB":
                    this.a++;
                    this.b--;
                    break;
                case "LB":
                    this.a--;
                    this.b--;
                    break;
            }
        }
    }

    public static boolean isInPosition(Position pos){
        return pos.a >= 'A' && pos.a <= 'H' && pos.b >= '1' && pos.b <= '8';
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king_token = st.nextToken();
        String stone_token = st.nextToken();

        Position king = new Position(king_token.charAt(0), king_token.charAt(1));
        Position stone = new Position(stone_token.charAt(0), stone_token.charAt(1));


        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N;i++){
            String move = br.readLine();
            Position king_tmp = new Position(king.a, king.b);
            Position stone_tmp = new Position(stone.a, stone.b);

            king_tmp.Move(move);
            if(king_tmp.a == stone_tmp.a && king_tmp.b == stone_tmp.b)
                stone_tmp.Move(move);

            if(isInPosition(king_tmp) && isInPosition(stone_tmp)) {
                king.a = king_tmp.a;
                king.b = king_tmp.b;
                stone.a = stone_tmp.a;
                stone.b = stone_tmp.b;
            }


        }

        System.out.println(String.valueOf(king.a) + king.b);
        System.out.println(String.valueOf(stone.a) + stone.b);

    }
}
