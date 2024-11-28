package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14940_쉬운최단거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer[i][j] = -1;
            }
        }

        Pos start = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    start = new Pos(i,j,0);
                } else if (map[i][j] == 0) {
                    answer[i][j] = 0;
                }
            }
        }

        boolean[][] visited = new boolean[n][m];

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        // bfs
        Queue<Pos> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Pos current = queue.poll();
            answer[current.x][current.y] = current.distance;

            for (int i = 0 ; i < 4 ; i++){
                int xi = current.x + dx[i];
                int yi = current.y + dy[i];
                if (xi>=0 && xi<n && yi>=0 && yi<m
                        && !visited[xi][yi] && map[xi][yi] == 1) {
                    queue.add(new Pos(xi,yi, current.distance+1));
                    visited[xi][yi] = true;
                }
            }
        }

        StringBuilder print = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                print.append(answer[i][j]).append(" ");
            }
            print.append("\n");
        }
        System.out.println(print);


    }

    static class Pos {
        int x;
        int y;
        int distance;

        public Pos(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
