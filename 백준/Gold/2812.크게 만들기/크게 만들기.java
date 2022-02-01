import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int size = n - k;

        sc.nextLine();
        String strNum = sc.nextLine();
        char[] arr = strNum.toCharArray();


        Deque<Character> dq = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            while (k > 0 && !dq.isEmpty() && arr[i] > dq.getLast()) {
                dq.removeLast();
                k--;
            }
            dq.addLast(arr[i]);
        }

        StringBuilder sb = new StringBuilder(500000);


        while (size > 0) {
            sb.append(dq.removeFirst());
            size--;
        }


        System.out.println(sb.toString());

    }

}
