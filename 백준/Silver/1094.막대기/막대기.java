import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(64);

        while(true){
            int sum = 0;
            for (int n : list) {
                sum += n;
            }
            Collections.sort(list);
            if(sum == x) break;
            if (sum >= x){
                int min = list.get(0);
                if(sum - (min / 2) >= x){
                    list.remove(0);
                    list.add(min / 2);
                }else{
                    list.remove(0);
                    list.add(min / 2);
                    list.add(min / 2);
                }
            }
        }

        System.out.println(list.size());

    }


}