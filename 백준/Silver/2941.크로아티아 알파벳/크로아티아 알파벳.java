
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int cnt = 0;
        int i = 0;
        int len = str.length();
        for (; i < len; i++) {

            if(str.charAt(i) == 'c' && i != len - 1){
                if(str.substring(i,i+2).equals("c=") || str.substring(i,i+2).equals("c-")){
                    cnt++;
                    i++;
                }else cnt++;
                continue;
            }

            if (str.charAt(i) == 'd') {
                if(i != len - 2 && i != len - 1){
                    if (str.substring(i, i + 2).equals("d-")) {
                        cnt++;
                        i++;
                    } else if (str.substring(i,i+3).equals("dz=")) {
                        cnt++;
                        i += 2;
                    } else cnt++;
                } else if (i != len - 1 && str.substring(i, i + 2).equals("d-")) {
                    cnt++;
                    i++;
                } else cnt++;
                continue;
            }

            if(str.charAt(i) == 'l' && i != len - 1){
                if(str.substring(i,i+2).equals("lj")){
                    cnt++;
                    i++;
                }else cnt++;
                continue;
            }

            if(str.charAt(i) == 'n' && i != len - 1){
                if(str.substring(i,i+2).equals("nj")){
                    cnt++;
                    i++;
                }else cnt++;
                continue;
            }

            if(str.charAt(i) == 's' && i != len - 1){
                if(str.substring(i,i+2).equals("s=")){
                    cnt++;
                    i++;
                }else cnt++;
                continue;
            }

            if(str.charAt(i) == 'z' && i != len - 1){
                if(str.substring(i,i+2).equals("z=")){
                    cnt++;
                    i++;
                }else cnt++;
                continue;
            }
            cnt++;
        }

        System.out.println(cnt);

    }

}