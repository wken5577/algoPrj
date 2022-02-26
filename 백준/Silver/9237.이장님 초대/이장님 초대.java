import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer [] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long day = 0;
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            day = Math.max(day, i + 1 + arr[i]);
        }

        System.out.println(day + 1);

    }
}