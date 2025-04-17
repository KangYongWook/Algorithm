package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14502_연구실 {

    static int n,m;
    static int[][] lab;
    static int[][] viruslab;
    static int answer;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][m];
        viruslab = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 3개의 벽을 선택하고
        // 0 빈칸 1 벽 2 바이러스
        setWall(0);

        // 2. 안전영역 구하기
        System.out.println(answer);

    }

    static void setWall(int count) {
        if (count == 3) {
            spreadVirus();
            answer = Math.max(answer,countSafeArea());
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    setWall(count+1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    static void spreadVirus() {
        for (int i = 0; i < n; i++) {
            viruslab[i] = lab[i].clone();
        }

        Queue<Pos> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (viruslab[i][j] == 2) {
                    que.add(new Pos(i, j));
                }
            }
        }

        while(!que.isEmpty()) {
            Pos virus = que.poll();
            viruslab[virus.x][virus.y] = 2;
            for (int i = 0; i < 4; i++) {
                int xi = virus.x + dx[i];
                int yi = virus.y + dy[i];

                if (xi >= 0 && xi < n && yi >= 0 && yi < m
                        && viruslab[xi][yi]==0) {
                    que.add(new Pos(xi,yi));
                }
            }
        }


    }

    static int countSafeArea() {
        int safeArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (viruslab[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        System.out.println(safeArea);
        return safeArea;
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
