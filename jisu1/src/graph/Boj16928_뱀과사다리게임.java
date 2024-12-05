package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16928_뱀과사다리게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> slide = new HashMap<>();
        for (int i = 0; i < n+m; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            slide.put(key, value);
        }

        int answer = 1;
        boolean[] visited = new boolean[101];
        Queue<Info> game = new LinkedList<>();
        game.add(new Info(1,0));
        visited[1] = true;

        while(!game.isEmpty()) {
            Info curr = game.poll();
            if (curr.x==100){
                System.out.println(curr.dice);
                return;
            }

            for (int j = 1; j <= 6 ; j++) {
                int move = curr.x + j;
                move = slide.get(move)==null? move : slide.get(move);
                if (move<=100 && !visited[move]) {
                    game.add(new Info(move, curr.dice+1));
                    visited[move] = true;
                }
            }
        }
    }

    static class Info {
        int x;
        int dice;

        public Info(int x, int dice) {
            this.x = x;
            this.dice = dice;
        }
    }
}
