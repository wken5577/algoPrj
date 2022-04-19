import java.util.*;

class Point{
    int x, y, dust;

    public Point(int x, int y, int dust) {
        this.x = x;
        this.y = y;
        this.dust = dust;
    }
}

public class Main{
    static int R, C, T, top, bottom;
    static int[][] board;
    static Queue<Point> q = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();

        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int n = sc.nextInt();
                board[i][j] = n;
                if(n == -1){
                    if(top == 0) top = i;
                    else bottom = i;
                }
            }
        }

        int cnt = 0;
        while (cnt < T){
            //미세먼지 확산
            spreadDust();

            //공기청정
            startCleanTop();
            startCleanBot();

            cnt++;
        }

        long result = countDust();
        System.out.println(result);
    }

    private static long countDust() {
        int cnt = 0;
        for (int[] ints : board) {
            for (int anInt : ints) {
                if(anInt > 0){
                    cnt += anInt;
                }
            }
        }


        return cnt;
    }

    private static void spreadDust() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int n =  board[i][j];
                if(n > 0){
                    q.offer(new Point(i, j, n));
                }
            }
        }

        while(!q.isEmpty()) {
            Point p = q.poll();
            int spreadDust = p.dust / 5;
            int cnt = 0;

            for (int j = 0; j < 4; j++) {
                int nx = p.x + dx[j];
                int ny = p.y + dy[j];

                if (0 <= nx && nx < R && 0 <= ny && ny < C && board[nx][ny] >= 0) {
                    cnt++;
                    board[nx][ny] += spreadDust;
                }
            }

            board[p.x][p.y] -= cnt * spreadDust;

        }


    }

    private static void startCleanTop() {
        int left = top;

        board[left - 1][0] = 0;
        left--;
        while (left >= 1) {
            board[left][0] = board[left - 1][0];
            left--;
        }

        int t = 1;
        while(t < C){
            board[0][t - 1] = board[0][t];
            t++;
        }

        int right = 1;
        while (right <= top) {
            board[right - 1][C - 1] = board[right][C - 1];
            right++;
        }

        int bot = C - 1;
        while (bot > 1) {
            board[top][bot] = board[top][bot - 1];
            bot--;
        }
        board[top][bot] = 0;


    }


    private static void startCleanBot() {
        int left = bottom;
        board[left + 1][0] = 0;
        left++;

        while (left < R - 1) {
            board[left][0] = board[left + 1][0];
            left++;
        }

        int bot = 0;
        while (bot < C - 1) {
            board[R - 1][bot] = board[R - 1][bot + 1];
            bot++;
        }

        int right = R - 1;
        while(right > bottom){
            board[right][C - 1] = board[right - 1][C - 1];
            right --;
        }

        int top = C - 1;
        while(top > 1){
            board[bottom][top] =  board[bottom][top - 1];
            top--;
        }
        board[bottom][top] = 0;

    }



}
