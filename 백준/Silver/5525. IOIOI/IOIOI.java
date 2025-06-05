import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static String s;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        s = br.readLine();

        int ret = 0, cnt = 0;

        char[] arr = s.toCharArray();

        for(int i = 1; i < m - 1;){
            if(arr[i - 1] == 'I' && arr[i] == 'O' && arr[i + 1] == 'I'){
                cnt++;
                if(cnt == n){
                    ret++;
                    cnt--;
                }
                i += 2;
            }else{
                i++;
                cnt = 0;
            }
        }
        System.out.println(ret);
    }
}
