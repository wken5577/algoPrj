
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0,-1};
    static int[][]board , ch;
    static int t,m,n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            board = new int[n][m];
            ch = new int[n][m];
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                board[y][x] = 1;
            }


            int answer = 0;
            for (int j = 0; j < n; j++) {
                for (int s = 0; s < m; s++) {
                    if (board[j][s] == 1) {
                        answer++;
                        DFS(j, s);
                    }
                }
            }

            System.out.println(answer);
        }

    }

    private static void DFS(int x, int y) {
            ch[x][y] = 1;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (0 <= nx && nx < n && 0 <= ny && ny < m && board[nx][ny] == 1 && ch[nx][ny] == 0) {
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
    }


}