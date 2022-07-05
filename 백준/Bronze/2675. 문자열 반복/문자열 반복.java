import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n ; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(stringTokenizer.nextToken());
            String S = stringTokenizer.nextToken();
            for(int j =0; j<S.length(); j++){
                for(int k =0; k<R; k++){
                    System.out.print(S.charAt(j));
                }
            }
            System.out.println();
        }
    }
}