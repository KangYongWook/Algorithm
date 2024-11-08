package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj2667_단지번호붙이기 {
    static int N,step;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visited = new boolean[N][N];

        PriorityQueue<Integer> danji = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    step = 0;
                    dfs(i,j);
                    danji.add(step);
                }
            }
        }

        System.out.println(danji.size());
        while(!danji.isEmpty()){
            System.out.println(danji.poll());
        }

    }

    private static void dfs(int x, int y) {
        step++;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xi = x + dx[i];
            int yi = y + dy[i];
            if (xi>=0 && xi<N && yi>=0 && yi<N
                    && !visited[xi][yi] && map[xi][yi] == '1'){
                dfs(xi,yi);
            }
        }

    }
}
