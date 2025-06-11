import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int t1 = 0, t2 = 0, len = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();

        while(t2 < n){
            cnt.put(arr[t2], cnt.getOrDefault(arr[t2], 0) + 1);

            while(cnt.size() > 2){
                cnt.put(arr[t1], cnt.getOrDefault(arr[t1], 0) - 1);
                if(cnt.get(arr[t1]) == 0) cnt.remove(arr[t1]);
                t1++;
            }
            len = Math.max(len, t2 - t1 + 1);
            t2++;
        }
        System.out.println(len);
    }
}
