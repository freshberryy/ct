import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int n, s, ret;


    static void dfs(int l, int sum){
        if(l == n){
            if(sum == s) ret++;
            return;
        }
        dfs(l + 1, sum + arr[l]);
        dfs(l + 1, sum);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if(s == 0) ret--;
        System.out.println(ret);
    }
}
