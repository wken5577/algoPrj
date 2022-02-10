
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 0;

        int i = 0;
        while (sum < n) {
            sum += ++i;
        }

        if (sum == n) {
            System.out.println(i);
        } else {
            System.out.println(i - 1);
        }

    }
}
