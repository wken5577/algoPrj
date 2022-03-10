import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int lenA = a.length();
        int lenB = b.length();

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < lenB - lenA + 1; i++) {
            int cnt = 0;
            for (int j = i; j < lenA + i; j++) {
                if(a.charAt(j - i) != b.charAt(j)) cnt++;
            }
            answer = Math.min(cnt,answer);
        }

        System.out.println(answer);

    }
}