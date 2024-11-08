package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178_미로탐색 {

    static class Pos{
        int x;
        int y;
        int step;

        public Pos(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static char[][] map;
    static boolean[][] visited;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int answer = 0;
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(0,0,1));
        visited[0][0] = true;

        while(!que.isEmpty()) {
            Pos p = que.poll();
            if (p.x == N-1 && p.y == M-1){
                answer = p.step;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int xi = p.x+dx[i];
                int yi = p.y+dy[i];

                if (0<=xi && xi<N && 0<=yi && yi<M
                        && !visited[xi][yi] && map[xi][yi] == '1'){
                    que.add(new Pos(xi,yi,p.step+1));
                    visited[xi][yi] = true;
                }
            }
        }
        return answer;
    }
}
