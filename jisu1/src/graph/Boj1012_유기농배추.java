package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1012_유기농배추 {

    static int count = 0;
    static int[][] map;
    static boolean[][] vistied;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int m,n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new int[m][n];
            vistied = new boolean[m][n];
            int[][] cabage = new int[k][2];

            for(int i=0; i<k ;i++) {
                st = new StringTokenizer(br.readLine());
                cabage[i][0] = Integer.parseInt(st.nextToken());
                cabage[i][1] = Integer.parseInt(st.nextToken());
                map[cabage[i][0]][cabage[i][1]] = 1;
            }

            count = 0;
            for(int i=0; i<k ;i++) {
                dfs(cabage[i][0],cabage[i][1]);
            }

            answer.append(count).append("\n");
        }
        System.out.println(answer);
    }

    private static void dfs(int x,int y) {
        if (!vistied[x][y]){
            count++;
        }

        // 탐색
        for (int i = 0; i < 4; i++) {
            int xi = x+dx[i];
            int yi = y+dy[i];

            if (-1 < xi && xi < m && -1 < yi && yi < n){
                if (!vistied[xi][yi] && map[xi][yi] == 1){
                    vistied[xi][yi] = true;
                    dfs(xi,yi);
                }
            }
        }
    }
}
