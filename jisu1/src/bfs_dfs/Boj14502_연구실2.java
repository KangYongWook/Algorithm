package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj14502_연구실2 {

    static int n, m , answer;
    static int[][] lab;
    static int[][] viruslab;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Pos[] combi = new Pos[3];
    static ArrayList<Pos> virusList = new ArrayList<>();
    static ArrayList<Pos> wallList = new ArrayList<>();

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

                if (lab[i][j] == 0) {
                    wallList.add(new Pos(i, j));
                } else if (lab[i][j] == 2) {
                    virusList.add(new Pos(i, j));
                }

            }
        }

        // 0 빈칸 1 벽 2 바이러스
        makeWallCombi(0, 0);

        System.out.println(answer);

    }

    static void makeWallCombi(int index, int start) {
        // 1. 3개의 벽을 선택하고
        if (index == 3) {
            // 2. 바이러스 퍼짐
            spreadVirus();

            // 3. 안전영역 구하기
            answer = Math.max(answer,countSafeArea());
            return;
        }

        for (int i = start; i < wallList.size(); i++) {
            combi[index] = wallList.get(i);
            makeWallCombi(index + 1, i + 1);
        }
    }

    static void spreadVirus() {
        for (int i = 0; i < n; i++) {
            viruslab[i] = lab[i].clone();
        }

        for (Pos wall : combi) {
            viruslab[wall.x][wall.y] = 1;
        }

        Queue<Pos> que = new LinkedList<>();
        for (Pos vi : virusList) {
            que.add(vi);
        }

        while (!que.isEmpty()) {
            Pos virus = que.poll();
            viruslab[virus.x][virus.y] = 2;
            for (int i = 0; i < 4; i++) {
                int xi = virus.x + dx[i];
                int yi = virus.y + dy[i];

                if (xi >= 0 && xi < n && yi >= 0 && yi < m
                        && viruslab[xi][yi] == 0) {
                    que.add(new Pos(xi, yi));
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

/*
4 4
2 1 0 0
1 0 0 0
0 0 0 1
0 0 1 2
 */