
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    static Integer[] arr;
    static int n;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        n = str.length();
        arr = new Integer[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = str.charAt(i) - '0';
            sum += arr[i];
        }
        if (!str.contains("0") || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }


    }

}
