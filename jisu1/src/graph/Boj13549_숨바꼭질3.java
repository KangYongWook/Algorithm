package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj13549_숨바꼭질3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int size = 100001;
        int[] visited = new int[100001];
        for (int i = 0; i < size; i++) {
            visited[i] = Integer.MAX_VALUE;
        }

        Position start = new Position(0, n);
        Queue<Position> que = new LinkedList<>();
        visited[n] = 0;
        que.add(start);

        while (!que.isEmpty()) {
            Position curr = que.poll();
            if (curr.idx == k) {
                System.out.println(visited[k]);
                return;
            }

            // 가중치가 0 이므로 가장 앞에 있어야한다........
            int move = curr.idx * 2;
            if (move >=0 && move < size && visited[move] > curr.time * 2) {
                visited[move] = curr.time;
                que.add(new Position(curr.time, move));
            }

            int before = curr.idx - 1;
            if (before >=0 && before < size && visited[before] > curr.time+1) {
                visited[before] = curr.time+1;
                que.add(new Position(curr.time+1, before));
            }

            int after = curr.idx + 1;
            if (after >=0 && after < size && visited[after] > curr.time+1) {
                visited[after] = curr.time+1;
                que.add(new Position(curr.time+1, after));
            }

        }

    }

    static class Position implements Comparable<Position> {
        int time;
        int idx;

        public Position(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }


        @Override
        public int compareTo(Position o) {
            return this.time - o.time;
        }
    }

}
