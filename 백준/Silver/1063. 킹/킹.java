import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[8][8];
        int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dr = {0, 0, -1, 1, 1, 1, -1, -1};

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        String king = st.nextToken();
        String stone = st.nextToken();

        int n = Integer.parseInt(st.nextToken());

        int kc = king.charAt(0) - 'A';
        int kr =  king.charAt(1) - '1';

        int sc = stone.charAt(0) -'A';
        int sr =stone.charAt(1) - '1';

        for (int i = 0; i < n; i++) {
            String next = br.readLine();

            int idx = -1;
            switch (next) {
                case "R" : idx = 0;
                break;
                case "L" : idx = 1;
                break;
                case "B" : idx = 2;
                break;
                case "T" : idx = 3;
                break;
                case "RT" : idx = 4;
                break;
                case "LT" : idx = 5;
                break;
                case "RB" : idx = 6;
                break;
                case "LB" : idx = 7;
                break;

            }

            int nextKc = kc + dc[idx];
            int nextKr = kr + dr[idx];
            if(!(0 <= nextKc && nextKc < 8) || !(0 <= nextKr && nextKr < 8)) continue;

            if (sc == nextKc && sr == nextKr) {
                int nextSc = sc + dc[idx];
                int nextSr = sr + dr[idx];
                if(!(0 <= nextSc && nextSc < 8) || !(0 <= nextSr && nextSr < 8)) continue;
                kc = nextKc;
                kr = nextKr;
                sc = nextSc;
                sr = nextSr;
            } else {
                kc = nextKc;
                kr = nextKr;
            }

        }

        StringBuffer kingSb = new StringBuffer();
        StringBuffer StroneSb = new StringBuffer();

        kingSb.append((char) (kc + 'A')).append((char) (kr + '1'));
        StroneSb.append((char) (sc + 'A')).append((char) (sr + '1'));

        System.out.println(kingSb);
        System.out.println(StroneSb);
        br.close();
    }
}