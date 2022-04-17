import java.util.*;
public class Main{
    static Stack<Character> st = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i != str.length() -1){
                String s = str.substring(i,i + 2);
                if(s.equals("()")){
                    cnt += st.size();
                    i++;
                } else{
                    char ch = str.charAt(i);
                    if(ch == '(') st.push(ch);
                    else{
                        cnt++;
                        st.pop();
                    }
                }
            }
        }

        cnt += st.size();

        System.out.println(cnt);


    }
}
