import java.util.*;

class Country {
    int x, y, popu;

    public Country(int x, int y, int popu) {
        this.x = x;
        this.y = y;
        this.popu = popu;
    }
}


public class Main {
    static int N,L,R, ans = 0;
    static int[][] country, ch;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Country> cityList;
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        country = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                country[i][j] = sc.nextInt();
            }
        }

        move();
        System.out.println(ans);

    }

    private static void move() {
        while (true) {
            ch = new int[N][N];
            flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(ch[i][j] == 0) search(i, j);
                }
            }

            if(!flag) return;
            ans++;
        }


    }

    private static void search(int x, int y) {
        Queue<Country> q = new LinkedList<>();
        cityList = new ArrayList<>();
        ch[x][y] = 1;

        q.add(new Country(x,y,country[x][y]));

        while (!q.isEmpty()) {
            Country c = q.poll();
            int cPopu = c.popu;
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (!(0 <= nx && nx < N && 0 <= ny && ny < N)) continue;

                int nPopu = country[nx][ny];
                if (L <= Math.abs(cPopu - nPopu) && Math.abs(cPopu - nPopu) <= R && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    q.offer(new Country(nx, ny, nPopu));
                    cityList.add(new Country(nx, ny, nPopu));
                }

            }
        }

        if(cityList.isEmpty()) return;

        flag = true;
        cityList.add(new Country(x,y,country[x][y]));
        int cityCnt = cityList.size();
        int sum = 0;

        for (Country c : cityList) {
            sum += c.popu;
        }

        int changePopu = sum / cityCnt;
        for (Country c : cityList) {
            country[c.x][c.y] = changePopu;
        }

    }

}