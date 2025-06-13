import java.io.*;
import java.util.*;

public class Main {

    static class Shark{
        int y, x, time;

        Shark(int y, int x, int time){
            this.y = y; this.x = x; this.time = time;
        }
    }

    static int n;
    static int[][] map = new int[20][20];
    static int sharkSize, sharkEat;
    static Shark shark;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    shark = new Shark(i, j, 0);
                    sharkSize = 2;
                    sharkEat = 0;
                    map[i][j] = 0;
                }
            }
        }

        boolean isUpdate = true;
        while(isUpdate){
            isUpdate = false;

            boolean[][] visited = new boolean[20][20];
            Queue<Shark> q = new LinkedList<>();
            visited[shark.y][shark.x] = true;
            q.offer(shark);

            Shark candi = new Shark(20, 0, -1);
            while(!q.isEmpty()){
                Shark cur = q.poll();
                if(candi.time != -1 && candi.time < cur.time){
                    break;
                }

                if(map[cur.y][cur.x] < sharkSize && map[cur.y][cur.x] != 0){
                    isUpdate = true;
                    if(candi.y > cur.y || (candi.y == cur.y && candi.x > cur.x)){
                        candi = cur;
                    }
                }

                for(int dir = 0; dir < 4; dir++){
                    Shark next = new Shark(cur.y + dy[dir], cur.x + dx[dir], cur.time + 1);

                    if(next.y < 0 || next.y >= n || next.x < 0 || next.x >= n )continue;

                    if(!visited[next.y][next.x] && map[next.y][next.x] <= sharkSize){
                        visited[next.y][next.x] = true;
                        q.offer(next);
                    }
                }
            }
            if(isUpdate){
                shark = candi;
                sharkEat++;
                if(sharkEat == sharkSize){
                    sharkSize++;
                    sharkEat = 0;
                }
                map[shark.y][shark.x] = 0;
            }
        }
        System.out.println(shark.time);
    }
}
