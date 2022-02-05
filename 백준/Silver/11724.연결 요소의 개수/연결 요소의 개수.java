
import java.util.*;

public class Main {
    static int n, m, answer = 0;
    static int[][] cc;
    static int[] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        cc = new int[n + 1][n + 1];
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            cc[x][y] = 1;
            cc[y][x] = 1;
        }
        BFS();
        System.out.println(answer);
    }

    private static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(ch[i] == 0){
                ch[i] = 1;
                q.add(i);
                while (!q.isEmpty()) {
                    int cp =q.poll();
                    for (int j = 1; j <= n; j++) {
                        if(cc[cp][j] == 1 && ch[j] == 0){
                            ch[j] = 1;
                            q.add(j);
                        }
                    }
                }
                answer++;
            }
        }


    }

}