import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n =sc.nextInt();
            sc.nextLine();
            String start = sc.nextLine();
            String target = sc.nextLine();
            int cntB = 0;
            int cntW = 0;
            for (int j = 0; j < n; j++) {
                if ((start.charAt(j) != target.charAt(j)) && start.charAt(j) =='W') {
                    cntB++;
                } else if ((start.charAt(j) != target.charAt(j)) && start.charAt(j) == 'B') {
                    cntW++;
                }
            }

            if (cntB == cntW) {
                System.out.println(cntB);
            } else if (cntB > cntW) {
                System.out.println(cntB - cntW + cntW);
            } else {
                System.out.println(cntW- cntB + cntB);
            }
        }

    }
}