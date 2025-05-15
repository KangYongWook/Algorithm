package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2206_벽부수고이동하기2 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static int n, m;
    static boolean[][][] visited;

    //맵을 [2][N][M] 크기로 지정하셔서 벽을 부수지 않은 경우를 [0][N][M], 벽을 부순 경우를 [1][N][M]로 표현하면
    //2*N*M 크기의 맵에 bfs를 한 번만 돌려서 문제를 푸실 수 있습니다

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        visited = new boolean[2][n][m];

        PriorityQueue<Dot> que = new PriorityQueue<>();
        que.add(new Dot(0, 0, 1, 1));
        visited[1][0][0] = true;

        while (!que.isEmpty()) {
            Dot d = que.poll();
            if (d.x == n - 1 && d.y == m - 1) {
                return d.move;
            }
            for (int i = 0; i < 4; i++) {
                int xi = d.x + dx[i];
                int yi = d.y + dy[i];

                if (xi >= 0 && xi < n && yi >= 0 && yi < m) {

                    //움질일 수 있는 경우
                    if (!visited[d.ableBreakCnt][xi][yi] && map[xi][yi] == '0') {
                        visited[d.ableBreakCnt][xi][yi] = true;
                        que.add(new Dot(xi, yi, d.move + 1, d.ableBreakCnt));
                    }

                    // 벽을 깰 수 있는 경우
                    else if (d.ableBreakCnt == 1 && !visited[0][xi][yi] && map[xi][yi] == '1') {
                        visited[0][xi][yi] = true;
                        que.add(new Dot(xi, yi, d.move + 1, 0));
                    }
                }
            }
        }
        return -1;
    }

    static class Dot implements Comparable<Dot> {
        int x;
        int y;
        int move;
        int ableBreakCnt;

        public Dot(int x, int y, int move, int ableBreakCnt) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.ableBreakCnt = ableBreakCnt;
        }

        public int compareTo(Dot d) {
            return this.move - d.move;
        }
    }
}
