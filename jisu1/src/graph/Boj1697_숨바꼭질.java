package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1697_숨바꼭질 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean[] visited = new boolean[100001];
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(n,0));
        visited[n] = true;

        while (!que.isEmpty()){
            Pos p = que.poll();
            if (p.x == k) {
                System.out.println(p.step);
                return;
            }

            if (p.x+1<=100000 && !visited[p.x+1]) {
                que.add(new Pos(p.x+1, p.step+1));
                visited[p.x+1] = true;
            }

            if (p.x-1>=0 && !visited[p.x-1]) {
                que.add(new Pos(p.x - 1, p.step + 1));
                visited[p.x-1] = true;
            }

            if (p.x*2<=100000 && !visited[p.x*2]) {
                que.add(new Pos(p.x * 2, p.step + 1));
                visited[p.x*1] = true;
            }
        }

    }

    static class Pos {
        int x;
        int step;

        public Pos(int x, int step) {
            this.x = x;
            this.step = step;
        }
    }
}
