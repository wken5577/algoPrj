import java.util.Scanner;

public class Main {
    static int N,M, H, lineNum = 0, startPosition;
    static int[][] map;
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();

        map = new int[H + 2][N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a][b] = 1;
        }

        for (int i = 0; i <= 3; i++) {
            lineNum = i;
            putLine(0, i);
        }
        System.out.println(-1);

    }

    private static void putLine(int cnt, int line) {
        if (cnt == line) {
            startRun();
            isSameLine();
        } else {
            for (int i = 1; i <= H; i++) {
                for (int j = 1; j <= N; j++) {
                    if(j == N) continue;
                    if (map[i][j] == 0 && map[i][j - 1] != 1 && map[i][j + 1] != 1) {
                        map[i][j] = 1;
                        putLine(cnt + 1, line);
                        map[i][j] = 0;
                    }

                }
            }
        }

    }

    private static void isSameLine() {
        if(!flag){
            System.out.println(lineNum);
            System.exit(0);
        }
    }

    private static void startRun() {
        for (int i = 1; i <= N; i++) {
            flag = false;
            startPosition = i;
            DFS(1,i);
            if(flag) break;
        }
    }

    private static void DFS(int x, int position) {
        if (x == H + 1) {
            if (position == startPosition) return;
            else flag = true;
        }
        else{
            if (map[x][position] == 1) {
                DFS(x + 1, position + 1);
            }
            else if (map[x][position - 1] == 1) {
                DFS(x + 1,position - 1);
            }
            else{
                DFS(x + 1, position);
            }
        }
    }


}