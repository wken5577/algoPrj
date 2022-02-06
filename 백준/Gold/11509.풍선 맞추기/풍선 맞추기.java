
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ballon = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            ballon[i] = num;
        }

        int[] flag = new int[1000000 + 1];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (flag[ballon[i]] ==0) {
                flag[ballon[i] - 1]++;
                cnt++;
            } else {
                flag[ballon[i]]--;
                flag[ballon[i] - 1]++;
            }
        }
        System.out.println(cnt);

    }
}