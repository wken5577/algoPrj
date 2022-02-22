
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();

        StringBuilder sb = new StringBuilder(str);

        int cnt = 0;
        for (int i = 0; i < n - 3; i++) {
            String tmp = sb.substring(i, i + 4);
            if(tmp.equals("XXXX")) sb.replace(i,i+4,"AAAA");
        }

        for (int i = 0; i < n - 1; i++) {
            String tmp = sb.substring(i, i + 2);
            if(tmp.equals("XX")) sb.replace(i, i + 2, "BB");
        }
        if (sb.toString().contains("X")) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb);
    }

}
