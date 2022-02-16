import java.util.*;

public class Main {
    static int[][] map, ch;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[9][9];
        ch = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        DFS(0,0);

    }

    private static void DFS(int x, int y) {

        if (y == 9) {
            DFS(x + 1, 0);
            return;
        }

        if (x == 9) {
            for (int[] ints : map) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if (map[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(x, y, i)) {
                    map[x][y] = i;
                    DFS(x,y + 1);
                }
            }
            map[x][y] = 0;
            return;
        }

        DFS(x, y + 1);

    }

    private static boolean possibility(int x, int y, int value){

        for (int i = 0; i < 9; i++) {
            if(map[x][i] == value) return false;
        }

        for (int i = 0; i < 9; i++) {
            if(map[i][y] == value) return false;
        }

        int row = (x / 3) * 3;
        int col = (y / 3) * 3;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if(map[i][j] == value) return false;
            }
        }

        return true;
    }


}