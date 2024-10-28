package bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj18111_마인크래프트 {
    static int n,m,b;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        int min = 0;
        int max = 256;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int blocks = Integer.parseInt(st.nextToken());
                map[i][j] = blocks;
                min = Math.min(min, blocks);
                max = Math.max(max, blocks);
            }
        }

        int answerTime = Integer.MAX_VALUE;
        int height = Integer.MIN_VALUE;
        for (int i = min; i <= max; i++) {
            int time = makeFlat(i);
            if (time == -1) {
                break;
            }
            if (answerTime>=time) {
                answerTime = time;
                height = Math.max(height,i);
            }
        }

        System.out.println(answerTime + " " + height);

    }

    public static int makeFlat(int height) {
        int time = 0;
        int remainBlock = b;
        for (int i = 0; i < n ;i++) {
            for (int j = 0; j < m; j++) {
                int currBlocks = map[i][j];
                if (currBlocks < height) {
                    // 2. 땅이 기준 높이보다 작기때문에 블록을 올린 후 인벤토리에서 제거한다
                    time += (height-currBlocks);
                    remainBlock -= height-currBlocks;

                } else if (currBlocks > height) {
                    // 1. 땅이 기준 높이보다 크기때문에 블록을 제거한 후 인벤토리에 채운다
                    time += (currBlocks-height) * 2;
                    remainBlock += currBlocks-height;

                }
            }
        }
        if (remainBlock < 0) {
            return -1;
        }

        return time;
    }
}

/*
3 5 7
0 256 0 256 0
256 0 256 0 256
0 256 0 256 0
---------
3542 7

정답 2870 119

1 7 10
65 64 64 64 63 62 0
-------
148 56
 */