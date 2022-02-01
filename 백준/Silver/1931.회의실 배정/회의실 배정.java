
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//1931
class Time implements Comparable<Time>{
    int st;
    int et;

    public Time(int st, int et) {
        this.st = st;
        this.et = et;
    }


    @Override
    public int compareTo(Time o) {
        if(this.et == o.et) return this.st - o.st;
        return this.et - o.et;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Time(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);

        int answer = 0;
        int endTime = 0;
        for (int i = 0; i < n; i++) {
            Time t = list.get(i);
            if (t.st >= endTime) {
                answer++;
                endTime = t.et;
            }
        }

        System.out.println(answer);

    }
}
