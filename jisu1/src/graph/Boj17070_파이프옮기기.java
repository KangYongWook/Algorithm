package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj17070_파이프옮기기 {
    static int[][] wall;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        wall = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                wall[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 8x% 에서 실패
        if (wall[n-1][n-1]==1) {
            System.out.println("0");
            return;
        }

        int[][] dp = new int[n][n];
        Queue<Pipe> que = new LinkedList<>();
        que.add(new Pipe(0, 0, 1));

        // bfs 방식으로 풀기
        while (!que.isEmpty()) {
            Pipe curr = que.poll();
            dp[curr.x][curr.y]++;

            if (curr.direction == 0) {
                // 가로
                if (curr.y + 1 < n && wall[curr.x][curr.y + 1] == 0) {
                    // 가로이동
                    que.add(new Pipe(0, curr.x, curr.y + 1));
                }

                if (curr.x + 1 < n && curr.y + 1 < n && checkDiagonal(curr.x, curr.y)) {
                    // 대각선 이동
                    que.add(new Pipe(2, curr.x + 1, curr.y + 1));
                }

            } else if (curr.direction == 1) {
                // 세로
                if (curr.x + 1 < n && wall[curr.x + 1][curr.y] == 0) {
                    // 세로이동
                    que.add(new Pipe(1, curr.x+1, curr.y ));
                }

                if (curr.x + 1 < n && curr.y + 1 < n && checkDiagonal(curr.x, curr.y)) {
                    // 대각선 이동
                    que.add(new Pipe(2, curr.x + 1, curr.y + 1));
                }

            } else {
                // 대각선
                if (curr.x + 1 < n && wall[curr.x + 1][curr.y] == 0) {
                    // 세로이동
                    que.add(new Pipe(1, curr.x+1, curr.y ));
                }

                if (curr.y + 1 < n && wall[curr.x][curr.y + 1] == 0) {
                    // 가로이동
                    que.add(new Pipe(0, curr.x, curr.y + 1));
                }

                if (curr.x + 1 < n && curr.y + 1 < n && checkDiagonal(curr.x, curr.y)) {
                    // 대각선 이동
                    que.add(new Pipe(2, curr.x + 1, curr.y + 1));
                }
            }
        }

        System.out.println(dp[n-1][n-1]);

    }

    private static boolean checkDiagonal(int x, int y) {
        boolean result = true;
        int[] dx = {0, 1, 1};
        int[] dy = {1, 0, 1};
        for (int i = 0; i < 3; i++) {
            int xi = x + dx[i];
            int yi = y + dy[i];
            if (wall[xi][yi] == 1) {
                return false;
            }
        }
        return result;
    }

    static class Pipe {
        // 0 가로; 1 세로; 2 대각선
        int direction;
        int x;
        int y;

        public Pipe(int direction, int x, int y) {
            this.direction = direction;
            this.x = x;
            this.y = y;
        }
    }
}
