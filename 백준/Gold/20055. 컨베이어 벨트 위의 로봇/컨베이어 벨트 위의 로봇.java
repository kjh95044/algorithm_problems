import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int result, N, K, durabilityCnt;

    static class Belt {
        boolean hasRobot;
        int durability;

        public Belt(boolean hasRobot, int durability) {
            this.hasRobot = hasRobot;
            this.durability = durability;
        }

        public Belt(int durability) {
            this.durability = durability;
        }

        @Override
        public String toString() {
            return "Belt{" +
                    "hasRobot=" + hasRobot +
                    ", durability=" + durability +
                    '}';
        }
    }

    static Belt[] belts;

//    static Belt beltCopy(Belt b){
//        return new Belt(b.hasRobot, b.durability);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        belts = new Belt[2 * N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            int durability = Integer.parseInt(st.nextToken());
            belts[i] = new Belt(durability);

            if (durability == 0) {
                durabilityCnt++;
            }
        }

        // 4. 내구도 0인게 K 이상이면 종료
        while (durabilityCnt < K) {
            result ++;
//            System.out.println(Arrays.toString(belts));
            // 1. 벨트 회전
            Belt temp = (belts[2*N-1]);
            for (int i = 2*N-1; i > 0; i--) {
                belts[i] = (belts[i-1]);
            }
            belts[N-1].hasRobot = false;
            belts[0] = temp;
//            System.out.println(Arrays.toString(belts));

            // 2. 로봇 이동 (조건 : 이동 칸에 로봇 없어야하고 내구도 1이상이어야함. 먼저 올라간 로봇부터 이동

            Belt now = belts[2*N-1];
            Belt target = belts[0];
            move(now, target);
//            belts[2*N-1] = now;
//            belts[0] = target;

            for (int i = 2*N-1; i > 0; i--) {
                now = belts[i-1];
                target = belts[i];
//                System.out.println("before : " + belts[i]);
                // 함수로 뺀다고 now 변수에 넣어놓고 now값만 바꾸고 배열에 업데이트를 안해줘서 논리 오류가 생겼다.
                move(now, target);
//                belts[i-1] = now;
//                belts[i] = target;

//                System.out.println("after : " + belts[i]);
            }
            belts[N-1].hasRobot = false;

            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 로봇을 올린다.
            if(belts[0].durability>=1){
                belts[0].hasRobot = true;
                belts[0].durability--;
                if(belts[0].durability==0){
                    durabilityCnt ++;
                }
            }
        }
        System.out.println(result);
    }

    private static void move(Belt now, Belt target) {
        if(!target.hasRobot && now.hasRobot && target.durability>=1) {
            target.hasRobot = true;
            now.hasRobot = false;
            target.durability--;
            if(target.durability==0){
                durabilityCnt ++;
            }
        }
    }
}