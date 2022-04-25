import java.util.*;


public class Main {
    static int[][] board = new int[5][5];
    static Set<String> numbers = new HashSet<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String number = "";
                DFS(i ,j ,number);
            }
        }

        System.out.println(numbers.size());

    }

    private static void DFS(int x, int y, String number) {
        if(number.length() == 6){
            numbers.add(number);
        }else{
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if(0 <= nx && nx < 5 && 0 <= ny && ny < 5){
                    DFS(nx, ny, number + board[nx][ny]);
                }
            }
        }

    }
}
