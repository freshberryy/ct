import java.io.*;
import java.util.*;

public class Main {

    static class Point{
        long x, y;
        Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Point[] arr = new Point[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            arr[i] = new Point(x, y);
        }

        double ret = 0;

        for(int i = 0; i < n; i++){
            Point p1 = arr[i];
            Point p2 = arr[(i + 1) % n];
            ret += (p1.x * p2.y) - (p1.y * p2.x);
        }

        System.out.printf("%.1f\n", Math.abs(ret) / 2.0);
    }
}
