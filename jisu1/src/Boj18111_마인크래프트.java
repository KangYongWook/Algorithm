import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj18111_마인크래프트 {
    static class Flat {
        int time;
        int ground;

        public Flat(int time, int ground) {
            this.time = time;
            this.ground = ground;
        }
    }

    static class Position {
        int x;
        int y;
        int blocks;

        public Position(int x, int y, int blocks) {
            this.x = x;
            this.y = y;
            this.blocks = blocks;
        }
    }

    static int b;
    static ArrayList<Position> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int blocks = Integer.parseInt(st.nextToken());
                map.add(new Position(i,j,blocks));
            }
        }

        // 블록이 큰 순서대로 좌표 정렬하기
        // 0,0 부터 순차적으로 돌라는 조건이 없음
        Collections.sort(map, new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return o2.blocks- o1.blocks;
            }
        });

        PriorityQueue<Flat> answerPrio = new PriorityQueue<>(new Comparator<Flat>() {
            @Override
            public int compare(Flat o1, Flat o2) {
                if (o1.time == o2.time) {
                    return o2.ground - o1.ground;
                }
                return o1.time - o2.time;
            }
        });

        for (int i = 0; i <= 256; i++) {
            int time = makeFlat(i);
            if (time != -1) {
                answerPrio.add(new Flat(time, i));
            }
        }

        Flat answer = answerPrio.poll();
        System.out.println(answer.time + " " + answer.ground);

    }

    public static int makeFlat(int height) {
        int time = 0;
        int remainBlock = b;
        for (Position p : map) {
            if (p.blocks < height) {
                // 2. 땅이 기준 높이보다 작기때문에 블록을 올린 후 인벤토리에서 제거한다
                time += (height-p.blocks);
                remainBlock -= height-p.blocks;
                if (remainBlock < 0) {
                    return -1;
                }

            } else if (p.blocks > height) {
                // 1. 땅이 기준 높이보다 크기때문에 블록을 제거한 후 인벤토리에 채운다
                time += (p.blocks-height) * 2;
                remainBlock += p.blocks-height;

            }
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
 */