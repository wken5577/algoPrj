import java.util.*;

class Point {
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}


public class Main {
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Map<Character,Point>> q;
    static int[][] map;
    static int ans = -1, cnt = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();
        map = new int[M][N];
        q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < N; j++) {
                char ch = str.charAt(j);
                if(ch == '#') map[i][j] = -1;
                else if(ch == 'B'){
                    Map<Character, Point> map = new HashMap<>();
                    if(q.size() == 0){
                        map.put('B',new Point(i,j));
                        q.add(map);
                    } else if (q.size() == 1) {
                        q.peek().put('B',new Point(i,j));
                    }
                }
                else if(ch == 'R'){
                    Map<Character, Point> map = new HashMap<>();
                    if(q.size() == 0){
                        map.put('R',new Point(i,j));
                        q.add(map);
                    } else if (q.size() == 1) {
                        q.peek().put('R',new Point(i,j));
                    }

                }
                else if(ch == 'O') map[i][j] = 2;
            }
        }

        BFS();
        System.out.println(ans);

    }

    private static void BFS() {
        while (!q.isEmpty()) {
            int len = q.size();
            if(cnt > 10) return;

            for (int i = 0; i < len; i++) {
                Map<Character, Point> qMap = q.poll();
                Point r = qMap.get('R');
                Point b = qMap.get('B');

                for (int j = 0; j < 4; j++) {
                    move(r,b,j);
                }
            }

            cnt++;
        }
    }

    private static void move(Point r, Point b, int d) {
        int rx = r.x;
        int ry = r.y;
        int bx = b.x;
        int by = b.y;

        boolean flag = false;

        while(rx >= 0 && rx < M && ry>=0 && ry<N){
            rx += dx[d];
            ry += dy[d];

            if(map[rx][ry] == 2){
                flag = true;
                break;
            }

            if(map[rx][ry] == -1){
                rx -= dx[d];
                ry -= dy[d];
                break;
            }
        }

        while (bx >= 0 && bx < M && by >= 0 && by < N) {
            bx += dx[d];
            by += dy[d];

            if(map[bx][by] == 2){
                return;
            }

            if(map[bx][by] == -1) {
                bx -= dx[d];
                by -= dy[d];
                break;
            }
        }

        if(flag) {
            System.out.println(cnt);
            System.exit(0);
        }

        if(rx==bx && ry==by){
            if (d == 0 && r.x < b.x) {
                bx++;
            }
            else if(d == 0 && r.x > b.x){
                rx++;
            }
            else if(d == 1 && r.y < b.y){
                ry--;
            }
            else if (d == 1 && r.y > b.y) {
                by--;
            }
            else if(d == 2 && r.x < b.x){
                rx--;
            }
            else if(d == 2 && r.x > b.x){
                bx--;
            }
            else if(d == 3 && r.y < b.y){
                by++;
            }
            else if(d == 3 && r.y > b.y){
                ry++;
            }
        }

        Map<Character, Point> m = new HashMap<>();
        Point nr = new Point(rx, ry);
        Point nb = new Point(bx, by);
        if(r.equals(nr) && b.equals(nb)) return;

        m.put('R',nr);
        m.put('B',nb);
        q.offer(m);

    }

}