import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7569_토마토 {

    static int[][][] farm;
    static boolean[][][] visited;
    // 상하좌우앞뒤
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {0,0,0,0,-1,1};
    static int[] dh = {1,-1,0,0,0,0};
    static class Pos{
        int h;
        int y;
        int x;

        public Pos(int h, int y, int x) {
            this.h = h;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        farm = new int[h][n][m];
        visited = new boolean[h][n][m];
        int zeroTomato = 0;
        Queue<Pos> que = new LinkedList<>();
        for (int hi = 0; hi < h; hi++) {
            for (int yi = 0; yi < n; yi++) {
                st = new StringTokenizer(br.readLine());
                for (int xi = 0; xi < m; xi++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    farm[hi][yi][xi] = tomato;
                    if (tomato == 0){
                        zeroTomato++;
                    } else if (tomato ==1) {
                        que.add(new Pos(hi,yi,xi));
                        visited[hi][yi][xi] = true;
                    }
                }
            }
        }

        int day = 0;

        if (zeroTomato>0){

            // 일자를 세기위한 익은 토마토
            int tomatoForDaycount = que.size();

            while(!que.isEmpty()) {
                Pos t = que.poll();
                tomatoForDaycount--;

                for (int i = 0; i < 6; i++) {
                    int xi = t.x +dx[i];
                    int yi = t.y +dy[i];
                    int hi = t.h+dh[i];

                    if (0 <= xi && xi < m && 0 <= yi && yi < n && 0 <= hi && hi < h
                            && !visited[hi][yi][xi] && farm[hi][yi][xi] == 0) {
                        que.add(new Pos(hi,yi,xi));
                        visited[hi][yi][xi] = true;

                        // 주변에 익지않은토마토(farm == 0) 이 익었으므로
                        // 제로토마토 개수 감소
                        zeroTomato--;
                    }

                }

                // 주변 토마토 익히기 한 회차 다 돌림
                if (tomatoForDaycount==0){
                    day++;
                    tomatoForDaycount = que.size();
                    if (zeroTomato==0){
                        break;
                    }
                }

            }
        }

        // 아직 익지 않은 토마토가 남아 있다
        if (zeroTomato>0){
            day = -1;
        }

        System.out.println(day);
    }
}
