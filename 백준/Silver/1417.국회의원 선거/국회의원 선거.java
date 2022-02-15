
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dasom = sc.nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());


        for (int i = 0; i < n - 1; i++) {
            pq.offer(sc.nextInt());
        }

        int cnt = 0;
        while (pq.peek() >= dasom) {
            int x = pq.poll();
            pq.add(x - 1);
            dasom++;
            cnt++;
        }

        System.out.println(cnt);

    }
}