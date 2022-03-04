import java.util.Scanner;

public class Main {
    static int n, m;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
               map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 'W') makeLine(i,j);
            }
        }
        System.out.println(1);
        for (char[] chars : map) {
            for (char ch : chars) {
                System.out.print(ch);
            }
            System.out.println();
        }

    }

    private static void makeLine(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if(map[nx][ny] == 'S'){
                    System.out.println(0);
                    System.exit(0);
                }if(map[nx][ny] == '.') map[nx][ny] = 'D';
            }
        }

    }

}