import java.util.*;

public class Main {
    static int N, K;
    static int[] dx = {1, -1};
    static int minTime = 0, count = 0;
    static int[] time;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }

        time = new int[1000001];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[N] = 0;

        BFS();
        System.out.println(minTime);
        System.out.println(count);
    }

    private static void BFS() {
        q.add(N);
        int cnt = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            boolean flag = false;

            for (int i = 0; i < len; i++) {
                int cx = q.poll();

                if(cx == K){
                    minTime = cnt;
                    count++;
                    flag = true;
                    continue;
                }

                for (int j = 0; j < 2; j++) {
                    int nx1 = cx + dx[j];
                    if(nx1 < 0 || nx1 > 100000) continue;
                    if (time[nx1] == Integer.MAX_VALUE) {
                        time[nx1] = cnt;
                        q.offer(nx1);
                    } else if(time[nx1] == cnt) {
                        q.offer(nx1);
                    }

                }

                int nx2 = cx * 2;
                if(nx2 < 0 || nx2 > 100000) continue;
                if (time[nx2] == Integer.MAX_VALUE) {
                    time[nx2] = cnt;
                    q.offer(nx2);
                } else if(time[nx2] == cnt) {
                    q.offer(nx2);
                }
            }

            cnt++;

            if(flag) return;

        }


    }

}