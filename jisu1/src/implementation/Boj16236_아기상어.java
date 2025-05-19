package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj16236_아기상어 {

    static Shark babyShark = null;
    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                // 아기상어 위치
                if (board[i][j] == 9) {
                    babyShark = new Shark(i, j);
                    board[i][j]=0;
                }
            }
        }

        int babySharkSize = 2;
        int time = 0;
        int eatSameSize = 0;

        while (true) {
            int move = goToFish(babySharkSize);
            if (move == -1) {
                break;
            }

            time += move;
            eatSameSize++;
            // 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가
            if (eatSameSize == babySharkSize) {
                babySharkSize++;
                eatSameSize=0;
            }
        }

        System.out.println(time);
    }

    static int goToFish(int babySharkSize) {
        boolean[][] visited = new boolean[n][n];
        Queue<Shark> que = new LinkedList<>();
        que.add(babyShark);
        visited[babyShark.x][babyShark.y] = true;

        PriorityQueue<Shark> eatFishList = new PriorityQueue<>();

        while (!que.isEmpty()) {
            Shark curr = que.poll();
            // 물고기 먹음
            if (board[curr.x][curr.y]!=0 && board[curr.x][curr.y]<babySharkSize) {
                eatFishList.add(curr);
            }

            for (int i = 0; i < 4; i++) {
                int xi = curr.x + dx[i];
                int yi = curr.y + dy[i];

                if (xi >= 0 && xi < n && yi >= 0 && yi < n &&
                        !visited[xi][yi] && board[xi][yi] <= babySharkSize) {
                    que.add(new Shark(xi, yi, curr.move+1));
                    visited[xi][yi] = true;
                }
            }
        }

        if (!eatFishList.isEmpty()){
            Shark eatenFish = eatFishList.poll();
            babyShark.x = eatenFish.x;
            babyShark.y = eatenFish.y;
            board[eatenFish.x][eatenFish.y] = 0;
            return eatenFish.move;
        }
        return -1;
    }

    static class Shark implements Comparable<Shark> {
        int x;
        int y;
        int move;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Shark(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }

        @Override
        public int compareTo(Shark o) {
            if (this.move == o.move) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.move-o.move;
        }
    }
}

