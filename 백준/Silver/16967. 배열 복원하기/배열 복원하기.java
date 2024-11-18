import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int H = sc.nextInt();
        int W = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        int[][] arrA = new int[H][W];
        int[][] arrB = new int[H+X][W+Y];

        for(int i=0; i<H+X; i++){
            for(int j=0; j<W+Y; j++){
                arrB[i][j] = sc.nextInt();
            }
        }

        // 위쪽 안 겹치는곳
        for(int i=0; i<X; i++){
            for(int j=0; j<W; j++){
                arrA[i][j] = arrB[i][j];
            }
        }

        // 왼쪽 안 겹치는 곳
        for(int i=X; i<H; i++){
            for(int j=0; j<W; j++){
                arrA[i][j] = arrB[i][j];
            }
        }

        // 겹치는 곳
        for(int i=X; i<H; i++) {
			for(int j=Y; j<W; j++) {
				arrA[i][j] = arrB[i][j] - arrA[i-X][j-Y];
			}
		}

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                sb.append(arrA[i][j] + " ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}