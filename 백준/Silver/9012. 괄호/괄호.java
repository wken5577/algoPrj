import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        sc.nextLine();


        for (int i = 0; i < t; i++) {
            String str = sc.nextLine();
            Stack<Character> st = new Stack<>();
            System.out.println(solution(st, str));

        }


    }

    private static String solution(Stack<Character> st, String str) {
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(') st.push('(');
            else{
                if(st.empty()) return "NO";
                else st.pop();
            }
        }

        if(st.isEmpty()) return "YES";
        else return "NO";
    }
}