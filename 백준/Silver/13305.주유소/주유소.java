import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dis = new long[n - 1];
        long[] city = new long[n];
        for (int i = 0; i < n-1; i++) {
            dis[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            city[i] = sc.nextInt();;
        }


        for (int i = 0; i < n - 1; i++) {
            if (city[i] < city[i + 1]) {
                city[i+1] = city[i];
            }
        }

        long answer = 0;
        for (int i = 0; i < n - 1; i++) {
            answer += city[i] * dis[i];
        }
        System.out.println(answer);


    }
}
