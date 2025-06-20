import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static int[] dist = new int[100001];
    static int ret = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();

        q.offer(n);
        dist[n] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(dist[cur] > ret) break; 

            if(cur == k) {
                if(dist[cur] < ret) {
                    ret = dist[cur];
                    count = 1;
                } else if(dist[cur] == ret) {
                    count++;
                }
            }

            for(int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if(next < 0 || next > 100000) continue;

                if(dist[next] >= dist[cur] + 1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        System.out.println(ret);
        System.out.println(count);
    }
}
