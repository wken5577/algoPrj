public class Main{

    public static void main(String[] args) {
        int[] arr = new int[10001];

        for (int i = 1; i <= 10000; i++) {
            int n = i;
            int tmp = i;
            while(tmp != 0){
               n = n + tmp % 10;
               tmp /= 10;
            }
            if(n <= 10000)  arr[n] = 1;

        }

        for (int i = 1; i <= 10000; i++) {
            if (arr[i] == 0) {
                System.out.println(i);
            }
        }



    }



}
