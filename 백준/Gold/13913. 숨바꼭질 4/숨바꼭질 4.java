import java.util.*;
import java.util.stream.Collectors;

class Point{
    List<Integer> dis;
    int x;

    public Point(List<Integer> dis, int x) {
        this.dis = dis;
        this.x = x;
    }
}

public class Main {
    static int N, K;
    static Queue<Point> q = new LinkedList<>();
    static int[] dx = {1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        if (N - K >= 0) {
            int d = N - K;
            List<Integer> list = new ArrayList<>();

            while (N != K) {
                list.add(N--);
            }
            list.add(K);
            System.out.println(d);
            for (Integer n : list) {
                System.out.print(n +" ");
            }
            System.exit(0);
        }

        BFS();
    }

    private static void BFS() {
        List<Integer> l = new ArrayList<>();
        l.add(N);
        q.offer(new Point(l,N));

        int cnt = 0;
        int[] ch = new int[100001];
        Arrays.fill(ch,Integer.MAX_VALUE);
        ch[N] = 0;
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Point p = q.poll();
                int x = p.x;
                if (x == K) {
                    System.out.println(cnt);
                    for(int a : p.dis){
                        System.out.print(a + " ");
                    }
                    System.exit(0);
                }

                for (int j = 0; j < 2; j++) {
                    int nx = x + dx[j];
                    if(nx < 0 || nx > 100000) continue;
                    if(ch[nx] == Integer.MAX_VALUE || ch[nx] == cnt + 1) {
                        ch[nx] = cnt + 1;
                        ArrayList<Integer> collect = new ArrayList<>(p.dis);
                        collect.add(nx);
                        q.offer(new Point(collect, nx));
                    }
                }

                //순간이동
                int nx = x * 2;
                if(nx < 0 || nx > 100000) continue;
                if(ch[nx] == Integer.MAX_VALUE || ch[nx] == cnt + 1){
                    ch[nx] = cnt + 1;
                    ArrayList<Integer> collect = new ArrayList<>(p.dis);
                    collect.add(nx);
                    q.offer(new Point(collect, nx));
                }

            }
            cnt++;
        }
    }



}