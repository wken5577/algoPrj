
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean bool = false;

        if(n % 2 != 0) bool = true;

        if(bool) System.out.println("SK");
        else System.out.println("CY");

    }
}
