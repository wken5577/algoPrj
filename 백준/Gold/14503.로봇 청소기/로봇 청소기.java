import java.util.*;

public class Main {
    static int n,m,cnt = 1;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        DFS(r, c, d);
        System.out.println(cnt);
    }

    private static void DFS(int r, int c, int d) {
        map[r][c] = -1; //현재위치 청소

        for (int i = 0; i < 4; i++) {
            d = (d+3) % 4; // 방향전환(왼쪽으로)

            int nx = r + dx[d];
            int ny = c + dy[d];

            //앞에위치 확인 (청소가 안되어있으면 그쪽으로 이동)
            if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == 0) {
                cnt++;//청소횟수 증가
                DFS(nx, ny, d);
                return;
            }
        }

        int back = (d+2) % 4;
        int bx = r + dx[back];
        int by = c + dy[back];
        if ( 0 <= bx && bx < n && 0 <= by && by < m && map[bx][by] != 1) {
            DFS(bx,by,d);
        }

    }

}