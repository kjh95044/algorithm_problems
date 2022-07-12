import java.util.*;
import java.io.*;

class Main {
    static char[][] stars;

    public static void star(int n,int x, int y){
        if(n==1)
            stars[x][y] = '*';
        else{
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i!=1 || j!=1){
                        star(n/3, x + n/3*i, y + n/3*j);
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        stars = new char[n][n];

        for(int i=0; i < stars.length; i++){
            for(int j=0; j< stars.length; j++){
                stars[i][j] = ' ';
            }
        }

        star(n,0,0);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                bw.write(stars[i][j]);
            }
            bw.write("\n");
            bw.flush();
        }

    }
}