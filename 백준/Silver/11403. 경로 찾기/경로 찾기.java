import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][n];


        for(int i =0; i < n; i++) graph[i][i] = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int k = Integer.parseInt(st.nextToken());
                if(k == 1) graph[i][j] = 1;
                else graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(graph[i][k] < Integer.MAX_VALUE && graph[k][j] < Integer.MAX_VALUE){
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(graph[i][j] == Integer.MAX_VALUE) sb.append(0).append(' ');
                else sb.append(1).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
