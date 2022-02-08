
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sol(n,0));
    }
    public static int sol(int n, int count) {
        if (n < 2) {
            return count;
        }
        return Math.min(sol(n / 2, count + 1 + (n % 2)), sol(n / 3, count + 1 + (n % 3)));
    }


}