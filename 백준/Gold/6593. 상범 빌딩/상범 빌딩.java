import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int h,x,y;

    public Point(int h, int x, int y) {
        this.h = h;
        this.x = x;
        this.y = y;
    }
}


public class Main {
    static int L, R, C;
    static int[][][] building;
    static int[][][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] ds = {1, 0, -1};
    static Queue<Point> q;
    static final String FAIL = "Trapped!";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            if(L == 0) System.exit(0);

            sc.nextLine();
            building = new int[L][R][C];
            visit = new int[L][R][C];
            q = new LinkedList<>();

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = sc.nextLine();
                    for (int s = 0; s < C; s++) {
                        char ch = str.charAt(s);
                        if(ch == 'S')
                        {
                            visit[i][j][s] = 1;
                            q.add(new Point(i,j,s));
                        }
                        else if (ch == '#') building[i][j][s] = -1;
                        else if (ch =='E') building[i][j][s] = 2;
                    }
                }
                sc.nextLine();
            }

            int ans = BFS();
            if(ans == -1) System.out.println(FAIL);
            else System.out.println("Escaped in " + ans + " minute(s).");
        }

    }

    private static int BFS() {

        int cnt = 0;
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Point p = q.poll();
                int h = p.h;
                int x = p.x;
                int y = p.y;
                if (building[h][x][y] == 2) return cnt;


                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (0 <= nx && nx < R && 0 <= ny && ny < C
                            && building[h][nx][ny] != -1 && visit[h][nx][ny] == 0) {
                        visit[h][nx][ny] = 1;
                        q.add(new Point(h,nx,ny));
                    }
                }

                for (int j = 0; j < 3; j++) {
                    int nh = h + ds[j];
                    if(nh < 0 || nh >= L) continue;
                    if (building[nh][x][y] != -1 && visit[nh][x][y] == 0) {
                        visit[nh][x][y] = 1;
                        q.add(new Point(nh,x,y));
                    }
                }
            }
            cnt++;

        }

        return -1;
    }


}