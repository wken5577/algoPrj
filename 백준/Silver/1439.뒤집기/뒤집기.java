
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();

        int cntOne = 0;
        int cntZero = 0;
        if(str.charAt(0) == '1') cntOne++;
        else cntZero++;

        for (int i = 1; i < n; i++) {
            if((str.charAt(i) != str.charAt(i-1)) && str.charAt(i) =='1') cntOne++;
            else if((str.charAt(i) != str.charAt(i-1)) && str.charAt(i) =='0') cntZero++;
        }


        System.out.println(Math.min(cntOne,cntZero));

    }
}
