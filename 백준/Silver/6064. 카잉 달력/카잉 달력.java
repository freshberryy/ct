import java.io.*;
import java.util.*;

public class Main {
    static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = M * N / gcd(M, N);
            int k = x;
            boolean found = false;

            while (k <= lcm) {
                if ((k - 1) % N + 1 == y) {
                    System.out.println(k);
                    found = true;
                    break;
                }
                k += M;
            }

            if (!found) {
                System.out.println(-1);
            }
        }
    }
}
