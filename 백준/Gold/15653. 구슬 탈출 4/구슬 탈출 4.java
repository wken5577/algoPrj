import java.util.*;

class Point{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {
    static int N,M, ans;
    static char[][]board;
    static int[][][][] check;
    static Queue<Map<Character, Point>> q = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();
        check = new int[M][N][M][N];
        board = new char[M][N];
        Map<Character, Point> map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < N; j++) {
                char ch = str.charAt(j);
                if(ch == 'B'){
                    map.put('B', new Point(i, j));
                    board[i][j] = '.';
                } else if (ch == 'R') {
                    map.put('R', new Point(i, j));
                    board[i][j] = '.';
                } else{
                    board[i][j] = ch;
                }
            }
        }
        q.offer(map);
        ans = 1;
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Map<Character, Point> m = q.poll();
                Point r = m.get('R');
                Point b = m.get('B');
                check[r.x][r.y][b.x][b.y] = 1;

                for (int j = 0; j < 4; j++) {
                    search(r, b, j);
                }
            }
            ans++;
        }
        System.out.println(-1);

    }

    private static void search(Point r, Point b, int d) {
        int rx = r.x;
        int ry = r.y;

        int bx = b.x;
        int by = b.y;

        boolean flag = false;
        while (true){
            rx = rx + dx[d];
            ry = ry + dy[d];

            if (board[rx][ry] == 'O'){
                flag = true;
                break;
            }else if (board[rx][ry] == '#'){
                rx = rx - dx[d];
                ry = ry - dy[d];
                break;
            }

        }

        while (true){
            bx = bx + dx[d];
            by = by + dy[d];

            if (board[bx][by] == 'O'){
                return;
            }else if (board[bx][by] == '#'){
                bx = bx - dx[d];
                by = by - dy[d];
                break;
            }
        }

        if (flag) {
            System.out.println(ans);
            System.exit(0);
        }

        if (rx == bx && ry == by) {
            if (d == 0 && r.x < b.x) bx++;
            else if(d == 0 && r.x > b.x) rx++;
            else if(d == 1 && r.y < b.y) ry--;
            else if(d == 1 && r.y > b.y) by--;
            else if(d == 2 && r.x > b.x) bx--;
            else if(d == 2 && r.x < b.x) rx--;
            else if(d == 3 && r.y < b.y) by++;
            else if(d == 3 && r.y > b.y) ry++;
        }

        if(check[rx][ry][bx][by] == 1) return;

        check[rx][ry][bx][by] = 1;
        Map<Character, Point> map = new HashMap<>();
        map.put('R', new Point(rx,ry));
        map.put('B', new Point(bx,by));
        q.offer(map);
    }


}