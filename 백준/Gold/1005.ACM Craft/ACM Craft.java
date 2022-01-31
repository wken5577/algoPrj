import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st = null;
    static ArrayList<ArrayList<Integer>> list = null;
    static int[] cost, indegree;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            String str2 = br.readLine();
            st = new StringTokenizer(str2, " ");
            cost = new int[n+1];
            indegree = new int[n+1];
            for (int j = 1; j <= n; j++) {
                cost[j] = Integer.parseInt(st.nextToken());
            }

            list = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                list.add(new ArrayList<>());
            }

            for (int j = 0; j < k; j++) {
                String line = br.readLine();
                st = new StringTokenizer(line, " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.get(x).add(y);
                indegree[y] += 1;
            }

            int w = Integer.parseInt(br.readLine());
            answer = 0;
            int[] result = new int[n + 1];
            Queue<Integer> q = new LinkedList<>();

            for (int j = 1; j <= n; j++) {
                if(indegree[j] == 0){
                   result[j] = cost[j];
                   q.add(j);
                }
            }
            for (int j = 1; j <= n; j++) {
                int x = q.poll();

                for (int nx : list.get(x)) {
                    result[nx] = Math.max(result[nx],cost[nx] +result[x]);
                    if(--indegree[nx] == 0){
                        q.offer(nx);
                    }
                }
            }
            
            System.out.println(result[w]);
        }

    }


}