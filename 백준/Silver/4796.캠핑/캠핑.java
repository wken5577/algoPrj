
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cas = 0;
        while (true) {
            int l = sc.nextInt();
            int p = sc.nextInt();
            int v = sc.nextInt();

            if (l == 0 && p == 0 && v == 0) return;
            int answer = 0;

            int cnt = v / p;
            answer += cnt * l;
            if(v % p <= l) answer +=  v % p;
            else answer += l;

            System.out.println("Case " + ++cas + ": " + answer);

        }
    }
}

