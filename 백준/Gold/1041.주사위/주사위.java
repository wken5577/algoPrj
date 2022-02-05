import java.util.*;

public class Main {
    static long n;
    static int[] num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[6];

        for (int i = 0; i < 6; i++) {
            num[i] = sc.nextInt();
        }


        if (n == 1) {
            Arrays.sort(num);
            long sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += num[i];
            }
            System.out.println(sum);
            return;
        }


        System.out.println(solution());

    }

    private static long solution() {
        long answer = 0;

        long three = 4;
        long two = 8 * n - 12;
        long one = 4 * (n-1) * (n-2) + (n-2) * (n-2);

        long minThree,minTwo,minOne;

        long minAF = Math.min(num[0], num[5]);
        long minBE = Math.min(num[1], num[4]);
        long minCD = Math.min(num[2], num[3]);


        minOne = Math.min(minAF, Math.min(minBE, minCD));
        minTwo = Math.min(minAF + minBE, Math.min(minAF + minCD, minBE + minCD));
        minThree = minAF + minBE + minCD;



        answer = minThree * three + minTwo * two + minOne * one;

        return answer;

    }


}