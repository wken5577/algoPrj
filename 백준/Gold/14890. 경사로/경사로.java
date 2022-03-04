import java.util.Scanner;

public class Main {
    static int N,L, ans = 0;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                search(j, i);
            }
        }
        System.out.println(ans);


    }

    private static void search(int n, int line) {
        int[] arr = new int[N];
        int[] ch = new int[N];

        if (line == 0){
            for (int i = 0; i < N; i++) {
                arr[i] = map[n][i];
            }
        }
        if (line == 1) {
            for (int i = 0; i < N; i++) {
                arr[i] = map[i][n];
            }
        }

        int height = 0;
        for (int i = 0; i < N - 1; i++) {
            int dis = arr[i] - arr[i + 1];
            if(Math.abs(dis) > 1) return;

            if (dis == 1) {
                height = arr[i + 1];
                int from = i + 1;
                int to = i + L;
                if(to >= N) return;
                for (int j = from; j <= to; j++) {
                    if(arr[j] != height || ch[j] == 1) return;
                    ch[j] = 1;
                }
            }

            if (dis == -1) {
                height = arr[i];
                int from = i - L + 1;
                if(from < 0) return;

                for (int j = from; j <= i; j++) {
                    if(arr[j] != height || ch[j] == 1) return;
                    ch[j] = 1;
                }
            }
        }
        ans++;

    }




}