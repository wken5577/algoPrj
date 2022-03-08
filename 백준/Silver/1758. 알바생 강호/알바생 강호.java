import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] - i;
            if(num > 0) sum += num;
            else break;
        }

        System.out.println(sum);

    }

}