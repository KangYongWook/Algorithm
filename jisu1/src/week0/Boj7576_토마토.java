package week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576_토마토 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] farm = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<Pos> que = new LinkedList<>();

        int zeroTomato = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int t = Integer.parseInt(st.nextToken());
                farm[i][j] = t;
                if (t == 0) {
                    zeroTomato++;
                } else if (t == 1) {
                    que.add(new Pos(i, j));
                    visited[i][j] = true;
                }
            }
        }

        if (zeroTomato==0) {
            System.out.println("0");
            return;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int day = 0;
        int round = que.size();

        while (!que.isEmpty()) {
            Pos p = que.poll();
            round--;

            for (int i = 0; i < 4; i++) {
                int xi = p.x + dx[i];
                int yi = p.y + dy[i];

                if (0 <= xi && xi < n && 0 <= yi && yi < m
                        && !visited[xi][yi] && farm[xi][yi] == 0) {
                    zeroTomato--;
                    que.add(new Pos(xi, yi));
                    visited[xi][yi] = true;
                }
            }

            if (round == 0) {
                day++;
                round = que.size();

                if (zeroTomato == 0) {
                    break;
                }
            }
        }

        if (zeroTomato>0) {
            day = -1;
        }
        System.out.println(day);
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
