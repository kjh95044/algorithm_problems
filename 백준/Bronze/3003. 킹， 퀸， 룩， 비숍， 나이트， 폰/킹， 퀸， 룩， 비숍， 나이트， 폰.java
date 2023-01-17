import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();
        StringTokenizer st = new StringTokenizer(readLine);
        int king = Integer.parseInt(st.nextToken());
        int queen = Integer.parseInt(st.nextToken());
        int rook = Integer.parseInt(st.nextToken());
        int bishop = Integer.parseInt(st.nextToken());
        int knight = Integer.parseInt(st.nextToken());
        int pawn = Integer.parseInt(st.nextToken());

        king = 1 - king;
        queen = 1 - queen;
        rook = 2 - rook;
        bishop = 2 - bishop;
        knight = 2 - knight;
        pawn = 8 - pawn;

        System.out.println(king + " " +queen + " " +rook + " " +bishop + " " +knight + " " +pawn);

    }
}