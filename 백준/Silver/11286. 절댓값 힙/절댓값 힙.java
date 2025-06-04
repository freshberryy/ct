import java.io.*;
import java.util.*;

class Main {

    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b)->{
                    int aa = Math.abs(a);
                    int bb = Math.abs(b);

                    if(aa == bb) return a - b;
                    return aa - bb;
                }
        );

        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(pq.isEmpty()){
                    sb.append("0").append('\n');
                }else{
                    sb.append(pq.poll()).append('\n');
                }
            }else{
                pq.offer(x);
            }
        }

        System.out.println(sb);
    }
}
