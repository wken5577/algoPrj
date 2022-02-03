import java.util.Scanner;

public class Main {

    static long mod = 1000000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[][] dp = new long[n+2][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i]=1;
        }
        for (int i = 0; i <=9; i++) {
            dp[2][i] = i+1;
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += (dp[i-1][k]) % 10007;
                }
            }
        }
        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result +=dp[n][i];
        }
        System.out.println(result%10007);


    }
}